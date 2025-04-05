package com.example.cms.controller;

import com.example.cms.controller.dto.AlcoholDto;
import com.example.cms.controller.dto.RequestDto;
import com.example.cms.controller.exceptions.WineNotFoundException;
import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.AlcoholCategory;
import com.example.cms.model.entities.Wine;
import com.example.cms.model.entities.WineType;
import com.example.cms.model.repositories.AlcoholRepository;
import com.example.cms.model.repositories.CategoryRepository;
import com.example.cms.model.repositories.WineRepository;

import com.example.cms.model.repositories.WineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class WineController {

    @Autowired
    private final WineRepository repository;

    @Autowired
    private AlcoholRepository alcoholRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private WineTypeRepository wineTypeRepository;


    public WineController(WineRepository repository) {
        this.repository = repository;
    }

    // Retrieve all wines
    @GetMapping("/wine")
    public List<Wine> retrieveAllWines() {
        return repository.findAll();
    }

    // Create a new wine entry
    @Transactional
    @PostMapping("/wine")
    public Wine createWine(@RequestBody Wine newWine) {
        // Create new Alcohol entity
        Alcohol newAlcohol = new Alcohol();
        newAlcohol.setId(newWine.getId());
        newAlcohol.setName("Default");

        // Get category_id for alcohol
        AlcoholCategory category = categoryRepository.findById(2L)
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

        System.out.println("Wine ID: " + newWine.getId());
        System.out.println("WineType ID: " + (newWine.getWineType() != null ? newWine.getWineType().getId() : "null"));
        System.out.println("Wine Age: " + newWine.getAge());

        WineType wineType = wineTypeRepository.findById(newWine.getWineType().getId())
                .orElseThrow(() -> new RuntimeException("WineType not found"));

        newWine.setAlcohol(newAlcohol);
        newWine.setWineType(wineType);

        return repository.save(newWine);
    }

    // Retrieve a specific wine by ID
    @GetMapping("/wine/{id}")
    public Wine retrieveWine(@PathVariable("id") Long wineId) {
        return repository.findById(wineId)
                .orElseThrow(() -> new WineNotFoundException(wineId));
    }

    // Update an existing wine by ID
    @PutMapping("/wine/{id}")
    public Wine updateWine(@RequestBody Wine newWine, @PathVariable("id") Long wineId) {
        return repository.findById(wineId)
                .map(wine -> {
                    wine.setWineType(newWine.getWineType());
                    wine.setAge(newWine.getAge());
                    return repository.save(wine);
                })
                .orElseGet(() -> {
                    Alcohol alcohol = alcoholRepository.findById(wineId)
                            .orElseThrow(() -> new RuntimeException("Alcohol not found with id: " + wineId));
                    newWine.setAlcohol(alcohol);
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

    @PostMapping("/wine/search")
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
    @DeleteMapping("/wine/{id}")
    public void deleteWine(@PathVariable("id") Long wineId) {
        repository.deleteById(wineId);
    }

    // Search for wine by name
    @GetMapping("wine/search/{name}")
    public List<Wine> searchByName(@PathVariable String name) {
        return repository.searchByName(name);
    }

    // Retrieve wines by type (e.g., Red, White, Rosé)
    @GetMapping("wine/type/{type}")
    public List<Wine> getByType(@PathVariable String type) {
        return repository.findByType(type);
    }

    // Retrieve aged wines (e.g., wines aged over X years)
    @GetMapping("wine/aged/{minAge}")
    public List<Wine> getAgedWines(@PathVariable int minAge) {
        return repository.findAgedWines(minAge);
    }
}
