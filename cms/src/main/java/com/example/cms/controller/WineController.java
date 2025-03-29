package com.example.cms.controller;

import com.example.cms.controller.dto.AlcoholDto;
import com.example.cms.controller.dto.RequestDto;
import com.example.cms.controller.exceptions.WineNotFoundException;
import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.AlcoholCategory;
import com.example.cms.model.entities.Wine;
import com.example.cms.model.repositories.WineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class WineController {

    @Autowired
    private final WineRepository repository;

    public WineController(WineRepository repository) {
        this.repository = repository;
    }

    // Retrieve all wines
    @GetMapping("/wine")
    public List<Wine> retrieveAllWines() {
        return repository.findAll();
    }

    // Create a new wine entry
    @PostMapping("")
    public Wine createWine(@RequestBody Wine newWine) {
        return repository.save(newWine);
    }

    // Retrieve a specific wine by ID
    @GetMapping("/{id}")
    public Wine retrieveWine(@PathVariable("id") Long wineId) {
        return repository.findById(wineId)
                .orElseThrow(() -> new WineNotFoundException(wineId));
    }

    // Update an existing wine by ID
    @PutMapping("/{id}")
    public Wine updateWine(@RequestBody Wine newWine, @PathVariable("id") Long wineId) {
        return repository.findById(wineId)
                .map(wine -> {
                    wine.setWineType(newWine.getWineType());
                    wine.setAge(newWine.getAge());
                    return repository.save(wine);
                })
                .orElseGet(() -> {
                    return repository.save(newWine);
                });
    }

    // POST (Pairings) -- Wine

    // {
    // "WineType": "Red", ( ask frontend to implement)
    // "Flavor": "Sweet",
    // "Price": 3
    // }

    // 1. retrieve values for "WineType"
    // 2. retrieve values for "FlavorType"

    // 3. Call SQL function from WineRepository

    @PostMapping("/wine")
    List<Wine> pairWine(@RequestBody RequestDto requestDto) {
        // Find from category table with category string instead
        Long wineType = requestDto.getAlcoholType();
        String flavor = requestDto.getFlavor();
        Double quartile = requestDto.getPrice();

        List<Double> priceList = repository.findPricesByTypeAndFlavor(wineType, flavor);
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
            return repository.findAgedWines(wineType, flavor, threshold);
        } else {
            return List.of();
        }
    }

    // Delete a wine by ID
    @DeleteMapping("/{id}")
    public void deleteWine(@PathVariable("id") Long wineId) {
        repository.deleteById(wineId);
    }

    // Search for wine by name
    @GetMapping("/search/{name}")
    public List<Wine> searchByName(@PathVariable String name) {
        return repository.searchByName(name);
    }

    // Retrieve wines by type (e.g., Red, White, Rosé)
    @GetMapping("/type/{type}")
    public List<Wine> getByType(@PathVariable String type) {
        return repository.findByType(type);
    }

    // Retrieve aged wines (e.g., wines aged over X years)
    @GetMapping("/aged/{minAge}")
    public List<Wine> getAgedWines(@PathVariable int minAge) {
        return repository.findAgedWines(minAge);
    }
}
