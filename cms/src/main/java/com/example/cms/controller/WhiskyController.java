package com.example.cms.controller;

import com.example.cms.controller.exceptions.WhiskyNotFoundException;
import com.example.cms.model.entities.Whisky;
import com.example.cms.model.repositories.WhiskyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/whiskey")
public class WhiskyController {
    @Autowired
    private final WhiskyRepository repository;

    public WhiskyController(WhiskyRepository repository) {
        this.repository = repository;
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping()
    List<Whisky> retrieveAllWhisky() {
        return repository.findAll();
    }

    // Used alcoholId instead of whisky id because we might want to index all
    // alcohol later?
    // Need to confirm
    @GetMapping("/{id}")
    Whisky retrieveWhisky(@PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .orElseThrow(() -> new WhiskyNotFoundException(alcoholId));
    }

    // Post | Create
    @PostMapping()
    Whisky createWhisky(@RequestBody Whisky newWhisky) {
        return repository.save(newWhisky);
    }

    // Put | Update
    @PutMapping("/{id}")
    Whisky updateWhisky(@RequestBody Whisky newWhisky, @PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .map(whisky -> { // need to add partial update features later
                    whisky.setAge(newWhisky.getAge());
                    whisky.setBarrelType(newWhisky.getBarrelType());
                    return repository.save(whisky); // Save the updated existing object, not newWhisky
                })
                .orElseGet(() -> {
                    return repository.save(newWhisky);
                });
    }

    // Delete | Delete

    @DeleteMapping("/{id}")
    void deleteWhisky(@PathVariable("id") long alcoholId) {
        repository.deleteById(alcoholId);
    }

}