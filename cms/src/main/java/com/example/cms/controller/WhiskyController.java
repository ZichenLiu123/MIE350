package com.example.cms.controller;

import com.example.cms.controller.exceptions.WhiskyNotFoundException;
import com.example.cms.model.entities.Whisky;
import com.example.cms.model.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class WhiskyController {
    @Autowired
    private final WhiskyRepository repository;

    public WhiskyController(WhiskyRepository repository) {
        this.repository = repository;
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping("/whisky")
    List<Whisky> retrieveAllWhisky() {
        return repository.findAll();
    }

    // Used alcoholId instead of whisky id because we might want to index all alcohol later?
    // Need to confirm
    @GetMapping("/whisky/{id}")
    Whisky retrieveWhisky(@PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .orElseThrow(() -> new WhiskyNotFoundException(alcoholId));
    }

    // Post | Create
    @PostMapping("/whisky")
    Whisky createWhisky(@RequestBody Whisky newWhisky) {
        return repository.save(newWhisky);
    }
    // Put | Update
    @PutMapping("/whisky/{id}")
    Whisky updateWhisky(@RequestBody Whisky newWhisky, @PathVariable("id") long alcoholId) {
        return repository.findById(alcoholId)
                .map(whisky -> { // need to add partial update features later
                    whisky.setName(newWhisky.getName());
                    whisky.setPrice(newWhisky.getPrice());
                    whisky.setAmount(newWhisky.getAmount());
                    whisky.setAge(newWhisky.getAge());
                    whisky.setBarrelType(newWhisky.getBarrelType());
                    return repository.save(newWhisky);
                })
                .orElseGet(() -> {
                    newWhisky.setId(alcoholId);
                    return repository.save(newWhisky);
                });
    }

    // Delete | Delete

    @DeleteMapping("/whisky/{id}")
    void deleteWhisky(@PathVariable("id") long alcoholId) {
        repository.deleteById(alcoholId);
    }

}