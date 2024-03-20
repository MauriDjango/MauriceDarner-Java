package com.example.repository;

import com.example.models.BreweryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<BreweryEntity, Long> {
  // You can define custom query methods here if needed
}
