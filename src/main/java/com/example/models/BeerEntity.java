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
@Table(name = "beers")
public class BeerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "brewery_id")
  private Long breweryId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "cat_id")
  private Long catId;

  @Column(name = "style_id")
  private Long styleId;

  @Column(name = "abv")
  private float abv;

  @Column(name = "ibu")
  private float ibu;

  @Column(name = "srm")
  private float srm;

  @Column(name = "upc")
  private Long upc;

  @Column(name = "filepath")
  private String filePath;

  @Column(name = "descript", columnDefinition = "TEXT")
  private String description;

  @Column(name = "add_user")
  private Long addUser;

  @Column(name = "last_mod")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModified;

  // Constructors, getters, and setters
}
