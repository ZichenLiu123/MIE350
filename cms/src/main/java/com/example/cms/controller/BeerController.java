package com.example.cms.controller;

import com.example.cms.model.entities.Beer;
import com.example.cms.model.repositories.BeerRepository;
import com.example.cms.controller.exceptions.BeerNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BeerController {
    @Autowired
    private final BeerRepository repository;

    public BeerController(BeerRepository repository) {
        this.repository = repository;
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping("/alcohol/beer")
    List<Beer> retrieveAllBeer() {
        return repository.findAll();
    }

    // Used alcoholId instead of beer id because we might want to index all alcohol later?
    // Need to confirm
    @GetMapping("/alcohol/beer/{id}")
    Beer retrieveBeer(@PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .orElseThrow(() -> new BeerNotFoundException(alcoholId));
    }

    // Post | Create
    @PostMapping("/alcohol/beer")
    Beer createBeer(@RequestBody Beer newBeer) {
        return repository.save(newBeer);
    }
    // Put | Update
    @PutMapping("/alcohol/beer/{id}")
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

    @DeleteMapping("/alcohol/beer/{id}")
    void deleteBeer(@PathVariable("id") long alcoholId) {
        repository.deleteById(alcoholId);
    }

}