package com.example.cosmostravel.repositories;

import com.example.cosmostravel.data.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
