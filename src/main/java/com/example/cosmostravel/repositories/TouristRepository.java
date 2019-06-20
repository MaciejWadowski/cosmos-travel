package com.example.cosmostravel.repositories;

import com.example.cosmostravel.data.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
}
