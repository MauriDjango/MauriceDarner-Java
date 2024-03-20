package com.example.repository;

import com.example.models.StyleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<StyleEntity, Long> {
  // You can define custom query methods here if needed
}
