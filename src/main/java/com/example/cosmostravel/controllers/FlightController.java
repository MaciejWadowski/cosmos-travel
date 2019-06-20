package com.example.cosmostravel.controllers;

import com.example.cosmostravel.data.Flight;
import com.example.cosmostravel.data.Tourist;
import com.example.cosmostravel.exceptions.TouristNotFoundException;
import com.example.cosmostravel.repositories.FlightRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    private final FlightRepository repository;

    public FlightController(FlightRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/flights")
    List<Flight> all() {
        return  repository.findAll();
    }

    @PostMapping("/flights")
    Flight newFlight(@RequestBody Flight newTourist) {
        return repository.save(newTourist);
    }

    @GetMapping("/flights/{id}")
    Flight getFlight(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TouristNotFoundException(id));
    }

    @PutMapping("/flights/{id}")
    Flight replaceFlight(@RequestBody Flight newFlight, @PathVariable Long id) {
        return repository.findById(id)
                .map(flight -> {
                    flight.setArrivalDate(newFlight.getArrivalDate());
                    flight.setDepartureDate(newFlight.getDepartureDate());
                    flight.setSeatsCount(newFlight.getSeatsCount());
                    flight.setTicketPrice(newFlight.getTicketPrice());
                    return repository.save(flight);
                })
                .orElseGet(() -> {
                    newFlight.setId(id);
                    return repository.save(newFlight);
                });
    }

    @DeleteMapping("/tourists/{id}")
    void deleteFlight(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
