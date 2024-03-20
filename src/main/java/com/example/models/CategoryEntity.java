package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;


@Entity
@Data
@Table(name = "categories")
public class CategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "cat_name", nullable = false)
  private String categoryName;

  @Column(name = "last_mod", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModified;

  // Constructors, getters, and setters
}
