package com.example.cms.controller;

import com.example.cms.model.entities.Beer;
import com.example.cms.model.entities.Spirit;
import com.example.cms.model.repositories.BeerRepository;
import com.example.cms.controller.dto.BeerDto;
import com.example.cms.controller.exceptions.BeerNotFoundException;
import com.example.cms.model.repositories.AlcoholRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/alcohol/beer")
public class BeerController {
    @Autowired
    private final BeerRepository repository;

    @Autowired
    private AlcoholRepository alcoholRepository; // Add this

    public BeerController(BeerRepository repository, AlcoholRepository alcoholRepository) {
        this.repository = repository;
        this.alcoholRepository = alcoholRepository; // Update constructor
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping()
    List<Beer> retrieveAllBeer() {
        return repository.findAll();
    }

    // Used alcoholId instead of beer id because we might want to index all alcohol later?
    // Need to confirm
    @GetMapping("/{id}")
    Beer retrieveBeer(@PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .orElseThrow(() -> new BeerNotFoundException(alcoholId));
    }

    // Post | Create
    @PostMapping()
    Beer createBeer(@RequestBody Beer newBeer) {
        return repository.save(newBeer);
    }
    // Put | Update
    @PutMapping("/{id}")
    Beer updateBeer(@RequestBody Beer newBeer, @PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .map(beer -> { // need to add partial update features later
                    beer.setBeerType(newBeer.getBeerType());
                    beer.setBeerOrigin(newBeer.getBeerOrigin());
                    return repository.save(newBeer);
                })
                .orElseGet(() -> {
                    return repository.save(newBeer);
                });
    }

    // Delete | Delete

    @DeleteMapping("/{id}")
    void deleteBeer(@PathVariable("id") long alcoholId) {
        repository.deleteById(alcoholId);
    }

    @PostMapping("/search")
    List<Beer> pairSpirit(@RequestBody BeerDto beerDto) {
        // Find from category table with category string instead
        return repository.findBeer(beerDto.getBeerType(), beerDto.getBeerOrigin(), beerDto.getFlavour(), beerDto.getPrice());
    }

}