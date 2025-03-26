package com.example.cms.controller;

import com.example.cms.controller.dto.RequestDto;
import com.example.cms.controller.exceptions.AlcoholNotFoundException;
import com.example.cms.controller.exceptions.SpiritNotFoundException;
import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.Spirit;
import com.example.cms.model.entities.Wine;
import com.example.cms.model.repositories.SpiritRepository;
import com.example.cms.model.repositories.AlcoholRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SpiritController {
    @Autowired
    private final SpiritRepository repository;

    @Autowired
    private final AlcoholRepository alcoholRepository;

    public SpiritController(SpiritRepository repository, AlcoholRepository alcoholRepository) {
        this.repository = repository;
        this.alcoholRepository = alcoholRepository;
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping()
    List<Spirit> retrieveAllSpirit() {
        return repository.findAll();
    }

    @GetMapping("/spirit/{id}")
    Spirit retrieveSpirit(@PathVariable("id") long spiritId) {
        return repository.findById(spiritId)
                .orElseThrow(() -> new SpiritNotFoundException(spiritId));
    }

    @PostMapping("/spirit")
    List<Spirit> pairSpirit(@RequestBody RequestDto requestDto) {
        // Find from category table with category string instead
        return repository.findSpirit(requestDto.getAlcoholType(), requestDto.getFlavor(), requestDto.getPrice());
    }

//    // Delete | Delete
//    @DeleteMapping("/{id}")
//    void deleteSpirit(@PathVariable("id") long spiritId) {
//        // You may need to decide if you want to delete the associated Alcohol as well
//        repository.deleteById(spiritId);
//    }
}