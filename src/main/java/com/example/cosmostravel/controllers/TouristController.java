package com.example.cosmostravel.controllers;

import com.example.cosmostravel.data.Tourist;
import com.example.cosmostravel.exceptions.TouristNotFoundException;
import com.example.cosmostravel.repositories.TouristRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TouristController {

    private final TouristRepository repository;

    public TouristController(TouristRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tourists")
    List<Tourist> all() {
        return  repository.findAll();
    }

    @PostMapping("/tourists")
    Tourist newTourist(@RequestBody Tourist newTourist) {
        return repository.save(newTourist);
    }

    @GetMapping("/tourists/{id}")
    Tourist getTourist(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TouristNotFoundException(id));
    }

    @PutMapping("/tourists/{id}")
    Tourist replaceTourist(@RequestBody Tourist newTourist, @PathVariable Long id) {
        return repository.findById(id)
                .map(tourist -> {
                    tourist.setFirstName(tourist.getFirstName());
                    tourist.setLastName(tourist.getLastName());
                    tourist.setBirthDate(tourist.getBirthDate());
                    tourist.setCountry(tourist.getCountry());
                    tourist.setGender(tourist.getGender());
                    tourist.setNotes(tourist.getNotes());
                    return repository.save(tourist);
                })
                .orElseGet(() -> {
                    newTourist.setId(id);
                    return repository.save(newTourist);
                });
    }

    @DeleteMapping("/tourists/{id}")
    void deleteTourist(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
