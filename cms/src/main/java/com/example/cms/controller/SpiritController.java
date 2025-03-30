package com.example.cms.controller;

import com.example.cms.controller.dto.RequestDto;
import com.example.cms.controller.exceptions.AlcoholNotFoundException;
import com.example.cms.controller.exceptions.SpiritNotFoundException;
import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.AlcoholCategory;
import com.example.cms.model.entities.Spirit;
import com.example.cms.model.entities.SpiritType;
import com.example.cms.model.entities.Spirit;
import com.example.cms.model.entities.Spirit;
import com.example.cms.model.entities.Wine;
import com.example.cms.model.repositories.SpiritRepository;
import com.example.cms.model.repositories.AlcoholRepository;
import com.example.cms.model.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class SpiritController {
    @Autowired
    private final SpiritRepository repository;

    @Autowired
    private final AlcoholRepository alcoholRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public SpiritController(SpiritRepository repository, AlcoholRepository alcoholRepository) {
        this.repository = repository;
        this.alcoholRepository = alcoholRepository;
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping("/spirit")
    List<Spirit> retrieveAllSpirit() {
        return repository.findAll();
    }


    @GetMapping("/spirit/{id}")
    Spirit retrieveSpirit(@PathVariable("id") long spiritId) {
        return repository.findById(spiritId)
                .orElseThrow(() -> new SpiritNotFoundException(spiritId));
    }

    @PostMapping("/spirit")
    public Spirit createSpirit(@RequestBody Spirit newSpirit) {

        // Create new Alcohol entity
        Alcohol newAlcohol = new Alcohol();
        newAlcohol.setId(newSpirit.getId());
        newAlcohol.setName(newSpirit.getAlcohol().getName());

        // Get category_id for alcohol
        AlcoholCategory category = categoryRepository.findById(3L)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        newAlcohol.setCategory_id(category);
        //newAlcohol.setAmount(newSpirit.getAlcohol().getAmount());
        //newAlcohol.setPrice(newSpirit.getAlcohol().getPrice());
        //newAlcohol.setAbv(newSpirit.getAlcohol().getAbv());
        //newAlcohol.setTop1Flavor(newSpirit.getAlcohol().getTop1Flavor());
        //newAlcohol.setTop2Flavor("Unknown");
        //newAlcohol.setTop3Flavor("Unknown");
        newAlcohol.setCategory_id(category);
        newAlcohol.setAmount(0);
        newAlcohol.setPrice(0);
        newAlcohol.setAbv(0.0);
        newAlcohol.setTop1Flavor("Unknown");
        newAlcohol.setTop2Flavor("Unknown");
        newAlcohol.setTop3Flavor("Unknown");

        // Save new Alcohol entity
        alcoholRepository.save(newAlcohol);

        // Save new Spirit
        newSpirit.setId(newSpirit.getId());
        newSpirit.setAlcohol(newAlcohol);
        newSpirit.setSpiritType(newSpirit.getSpiritType());

        return repository.save(newSpirit);
    }


    // Put | Update
    @PutMapping("/spirit/{id}")
    Spirit updateSpirit(@RequestBody Spirit newSpirit, @PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .map(spirit -> { // need to add partial update features later
                    spirit.setSpiritType(newSpirit.getSpiritType());
                    return repository.save(newSpirit);
                })
                .orElseGet(() -> {
                    return repository.save(newSpirit);
                });
    }

    // Delete | Delete
    @DeleteMapping("/spirit/{id}")
    void deleteSpirit(@PathVariable("id") long alcoholId) {
        repository.deleteById(alcoholId);
    }

    @PostMapping("/spirit/search")
    List<Spirit> pairSpirit(@RequestBody RequestDto requestDto) {
        // Find from category table with category string instead
        Long spiritType = requestDto.getAlcoholType();
        String flavour = requestDto.getFlavor();
        Double quartile = requestDto.getPrice();

        List<Double> priceList = repository.findPricesByTypeAndFlavor(spiritType, flavour);
        List<Double> sortedPrices = priceList.stream().sorted().collect(Collectors.toList());
        

        if (!sortedPrices.isEmpty()) {
            int index;
            if (quartile == 0) {
                index = (int) (0.35 * sortedPrices.size());
            } else if (quartile == 1) {
                index = (int) (0.65 * sortedPrices.size());
                System.out.println(index);
            } else {
                index = sortedPrices.size() - 1;
            }

            Double threshold = sortedPrices.get(index);
            return repository.findSpirit(spiritType, flavour, threshold);
        } else {
            return List.of();
        }
    }

//    // Delete | Delete
//    @DeleteMapping("/{id}")
//    void deleteSpirit(@PathVariable("id") long spiritId) {
//        // You may need to decide if you want to delete the associated Alcohol as well
//        repository.deleteById(spiritId);
//    }
}