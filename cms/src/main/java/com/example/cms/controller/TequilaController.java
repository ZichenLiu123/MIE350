package com.example.cms.controller;

import com.example.cms.controller.exceptions.TequilaNotFoundException;
import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.Tequila;
import com.example.cms.model.repositories.TequilaRepository;
import com.example.cms.model.repositories.AlcoholRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/alcohol/spirit/tequila")
public class TequilaController {
    private final AlcoholRepository Arepository;

    @Autowired
    private final TequilaRepository repository;


    public TequilaController(TequilaRepository repository, AlcoholRepository Arepository) {
        this.repository = repository;
        this.Arepository = Arepository;
    }

    @GetMapping()
    List<Tequila> retrieveAllTequilas() {
        return repository.findAll();
    }

    @PostMapping()
    Tequila createTequila(@RequestBody Tequila newTequila) {
        return repository.save(newTequila);
    }

    @GetMapping("/{id}")
    Tequila retrieveTequila(@PathVariable("id") Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new TequilaNotFoundException(id));
    }

    @PutMapping("/{id}")
    Tequila updateTequila(@RequestBody Tequila newTequila, @PathVariable("id") Long id) {
        return repository.findById(id)
                .map(tequila -> {
                    tequila.setType(newTequila.getType());
                    return repository.save(tequila);
                })
                .orElseGet(() -> {
                    return repository.save(newTequila);
                });
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    // Search for tequila by name
    @GetMapping("/tequila/search/{name}")
    public List<Alcohol> searchByName(@PathVariable String name) {
        return Arepository.searchByNameTequila(name);
    }


    // Retrieve Tequila by type 
    @GetMapping("/type/{type}")
    public List<Tequila> getByType(@PathVariable String type) {
        return repository.findByType(type);
    }


}

