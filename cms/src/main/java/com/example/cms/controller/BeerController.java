package com.example.cms.controller;

import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.AlcoholCategory;
import com.example.cms.model.entities.Beer;
import com.example.cms.model.entities.Spirit;
import com.example.cms.model.repositories.BeerRepository;
import com.example.cms.controller.dto.BeerDto;
import com.example.cms.controller.exceptions.BeerNotFoundException;
import com.example.cms.model.repositories.AlcoholRepository;

import com.example.cms.model.repositories.CategoryRepository;
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
    private AlcoholRepository alcoholRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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
    public Beer createBeer(@RequestBody Beer newBeer) {

        // Create new Alcohol entity
        Alcohol newAlcohol = new Alcohol();
        newAlcohol.setId(newBeer.getId());
        newAlcohol.setName("Default");

        // Get category_id for alcohol
        AlcoholCategory category = categoryRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        newAlcohol.setCategory_id(category);
        newAlcohol.setAmount(0);
        newAlcohol.setPrice(0);
        newAlcohol.setAbv(0.0);
        newAlcohol.setTop1Flavor("Unknown");
        newAlcohol.setTop2Flavor("Unknown");
        newAlcohol.setTop3Flavor("Unknown");

        // Save new Alcohol entity
        alcoholRepository.save(newAlcohol);

        // Save new Beer
        newBeer.setId(newBeer.getId());
        newBeer.setAlcohol(newAlcohol);
        newBeer.setBeerOrigin(newBeer.getBeerOrigin());
        newBeer.setBeerType(newBeer.getBeerType());

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

    // Get beer pairings
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