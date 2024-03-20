package com.example.repository;

import com.example.models.BeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<BeerEntity, Long> {

}
