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
import java.util.stream.Collectors;

@CrossOrigin
@RestController
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
    @GetMapping("/beer")
    List<Beer> retrieveAllBeer() {
        return repository.findAll();
    }

    // Used alcoholId instead of beer id because we might want to index all alcohol later?
    // Need to confirm
    @GetMapping("/beer/{id}")
    Beer retrieveBeer(@PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .orElseThrow(() -> new BeerNotFoundException(alcoholId));
    }

    // Post | Create
    @PostMapping("/beer")
    Beer createBeer(@RequestBody Beer newBeer) {
        return repository.save(newBeer);
    }
    // Put | Update
    @PutMapping("/beer/{id}")
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

    @DeleteMapping("/beer/{id}")
    void deleteBeer(@PathVariable("id") long alcoholId) {
        repository.deleteById(alcoholId);
    }

    @PostMapping("/beer/search")
    List<Beer> pairWine(@RequestBody BeerDto beerDto) {
        String beerType = beerDto.getBeerType();
        String flavour = beerDto.getFlavour();
        Double quartile = beerDto.getPrice();

        List<Double> priceList = repository.findPricesByTypeAndFlavor(beerType, flavour);
        List<Double> sortedPrices = priceList.stream().sorted().collect(Collectors.toList());

        if (!sortedPrices.isEmpty()) {
            int index;
            if (quartile == 0) {
                index = (int) (0.35 * sortedPrices.size());
            } else if (quartile == 1) {
                index = (int) (0.65 * sortedPrices.size());
            } else {
                index = sortedPrices.size() - 1;
            }

            Double threshold = sortedPrices.get(index);
            return repository.findBeer(beerType, flavour, threshold);
        } else {
            return List.of();
        }

    }

}