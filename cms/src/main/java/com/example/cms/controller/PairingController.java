package com.example.cms.controller;

import com.example.cms.controller.dto.PairingDto;
import com.example.cms.controller.exceptions.PairingNotFoundException;
import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.Pairing;
import com.example.cms.model.repositories.AlcoholRepository;
import com.example.cms.model.repositories.PairingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PairingController {
    @Autowired
    private final PairingRepository repository;

    @Autowired
    private AlcoholRepository alcoholRepository;

    public PairingController(PairingRepository repository) {
        this.repository = repository;
    }

    // GET & POST & DELETE automatically built in Spring Repo. fns

    // Get | Read
    @GetMapping("/pairing")
    List<Pairing> retrieveAllPairing() {
        return repository.findAll();
    }

    // Used pairingId instead of beer id because we might want to index all pairing later?
    // Need to confirm
    @GetMapping("/pairing/{id}")
    Pairing retrievePairing(@PathVariable("id") long pairingId) {
        return repository.findById(pairingId)
                .orElseThrow(() -> new PairingNotFoundException(pairingId));
    }


    // Post | Create
    @PostMapping("/pairing/recommend")
    List<Alcohol> createPairing(@RequestBody PairingDto newPairing) {
        List<Long> alcoholIds = repository.findPairingFoodIds(
                newPairing.getFlavor(),
                newPairing.getFoodType()
        );

        return alcoholRepository.findAllById(alcoholIds);
    }

    // Put | Update
    @PutMapping("/pairing/{id}")
//    Pairing updatePairing(@RequestBody Pairing newPairing, @PathVariable("id") long pairingId) {
//        return repository.findById(pairingId)
//                .map(pairing -> { // need to add partial update features later
//                    pairing.setCategory(newPairing.getCategory());
//                    pairing.setFood(newPairing.getFood());
//                    pairing.setRecommend_Rank(newPairing.getRecommend_Rank());
//                    pairing.setMatch_flavour(newPairing.getMatch_flavour());
//                    return repository.save(newPairing);
//                })
//                .orElseGet(() -> {
//                    return repository.save(newPairing);
//                });
//    }

    // Delete | Delete

    @DeleteMapping("/pairing/{id}")
    void deletePairing(@PathVariable("id") long pairingId) {
        repository.deleteById(pairingId);
    }
}