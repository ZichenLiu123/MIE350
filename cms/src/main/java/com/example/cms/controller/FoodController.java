package com.example.cms.controller;

import com.example.cms.controller.exceptions.FoodNotFoundException;
import com.example.cms.model.entities.Food;
import com.example.cms.model.repositories.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FoodController {
    @Autowired
    private final FoodRepository repository;

    public FoodController(FoodRepository repository) {
        this.repository = repository;
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping("/food")
    List<Food> retrieveAllFood() {
        return repository.findAll();
    }

    // Used foodId instead of beer id because we might want to index all food later?
    // Need to confirm
    @GetMapping("/food/{id}")
    Food retrieveFood(@PathVariable("id") long Id) {
        return repository.findById(Id)
                .orElseThrow(() -> new FoodNotFoundException(Id));
    }

    // POST

    // 1. Type of food ( 5 types )
    // 2. Flavor
    // 3. Price

    




    // Post | Create
    @PostMapping("/food")
    Food createFood(@RequestBody Food newFood) {
        return repository.save(newFood);
    }
    // Put | Update
    @PutMapping("/food/{id}")
    Food updateFood(@RequestBody Food newFood, @PathVariable("id") long Id) {
        return repository.findById(Id)
                .map(food -> { // need to add partial update features later
                    food.setName(newFood.getName());
                    food.setFlavour(newFood.getFlavour());
                    return repository.save(newFood);
                })
                .orElseGet(() -> {
                    return repository.save(newFood);
                });
    }

    // Delete | Delete

    @DeleteMapping("/food/{id}")
    void deleteFood(@PathVariable("id") long Id) {
        repository.deleteById(Id);
    }
}
