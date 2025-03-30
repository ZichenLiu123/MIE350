package com.example.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.controller.dto.AlcoholDto;
import com.example.cms.controller.dto.RequestDto;
import com.example.cms.controller.exceptions.Non_AlcoholicNotFoundException;
import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.AlcoholCategory;
import com.example.cms.model.entities.Beer;
import com.example.cms.model.entities.Non_Alcoholic;
import com.example.cms.model.entities.Wine;
import com.example.cms.model.repositories.AlcoholRepository;
import com.example.cms.model.repositories.CategoryRepository;
import com.example.cms.controller.dto.Non_alcoholicDto;
import com.example.cms.controller.exceptions.Non_AlcoholicNotFoundException;
import com.example.cms.model.entities.Non_Alcoholic;
import com.example.cms.model.repositories.Non_AlcoholicRepository;
import java.util.stream.Collectors;

@CrossOrigin
@RestController

public class Non_AlcoholicController {
    private final Non_AlcoholicRepository repository;

    @Autowired
    private AlcoholRepository alcoholRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    public Non_AlcoholicController(Non_AlcoholicRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/alcohol/non-alcoholic")
    public List<Non_Alcoholic> retrieveAllNon_AlcoholicDrinks() {
        return repository.findAll();
    }

    @PostMapping("/alcohol/non-alcoholic/create")
    public Non_Alcoholic createnew(@RequestBody Non_Alcoholic newdrink) {
        // Create new Alcohol entity
        Alcohol newAlcohol = new Alcohol();
        newAlcohol.setId(newdrink.getId());
        newAlcohol.setName("Default");

        // Get category_id for alcohol
        AlcoholCategory category = categoryRepository.findById(4L)
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

        // Save new drink
        newdrink.setId(newdrink.getId());
        newdrink.setAlcohol(newAlcohol);
        newdrink.setAlcoholicEquivalent(newdrink.getAlcoholicEquivalent());
        newdrink.setIsCarbonated(newdrink.getIsCarbonated());

        return repository.save(newdrink);
    }

    // For recommending Non-alco
    @PostMapping("/alcohol/non-alcoholic")
    public List<Non_Alcoholic> non_Alcoholics_rec(@RequestBody Non_alcoholicDto non_alcoholicDto) {
        String flavor = non_alcoholicDto.getFlavor();
        Double quartile = non_alcoholicDto.getPrice();
        Boolean isCarbonated = non_alcoholicDto.getIsCarbonated();
        String alcoholicEquivalent = non_alcoholicDto.getAlcoholicEquivalent();

        List<Double> priceList = repository.findPricesByTypeAndFlavor(flavor, isCarbonated, alcoholicEquivalent);
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
            return repository.non_alcoholicRec(threshold, flavor, isCarbonated, alcoholicEquivalent);
        } else {
            return List.of();
        }
    }

    @GetMapping("/alcohol/non-alcoholic/{id}")
    public Non_Alcoholic retrieveNon_AlcoholicDrink(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new Non_AlcoholicNotFoundException(id));
    }

    @GetMapping("/alcohol/non-alcoholic/carbonated")
    public List<Non_Alcoholic> getCarbonatedDrinks() {
        return repository.findByIsCarbonatedTrue();
    }

    @GetMapping("/alcohol/non-alcoholic/non-carbonated")
    public List<Non_Alcoholic> getNonCarbonatedDrinks() {
        return repository.findByIsCarbonatedFalse();
    }

    @GetMapping("/alcohol/non-alcoholic/search")
    public List<Non_Alcoholic> searchAlcoholicEquivalent(@RequestParam String alcoholicEquivalent) {
        return repository.findByAlcoholicEquivalentContainingIgnoreCase(alcoholicEquivalent);
    }

    @PutMapping("/alcohol/non-alcoholic/{id}")
    public Non_Alcoholic updateNon_AlcoholicDrink(@RequestBody Non_Alcoholic updatedDrink,
            @PathVariable("id") Long id) {
        return repository.findById(id)
                .map(drink -> {
                    drink.setIsCarbonated(updatedDrink.getIsCarbonated());
                    drink.setAlcoholicEquivalent(updatedDrink.getAlcoholicEquivalent());
                    return repository.save(drink);
                })
                .orElseGet(() -> {
                    updatedDrink.setId(id);
                    return repository.save(updatedDrink);
                });
    }

    @DeleteMapping("/alcohol/non-alcoholic/{id}")
    public void deleteNon_AlcoholicDrink(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
