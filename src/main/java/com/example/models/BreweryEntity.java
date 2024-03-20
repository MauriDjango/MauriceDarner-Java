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
@Table(name = "breweries")
public class BreweryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "address1", nullable = false)
  private String address1;

  @Column(name = "address2")
  private String address2;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "state", nullable = false)
  private String state;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "country", nullable = false)
  private String country;

  @Column(name = "phone", nullable = false)
  private String phone;

  @Column(name = "website", nullable = false)
  private String website;

  @Column(name = "filepath", nullable = false)
  private String filepath;

  @Column(name = "descript", nullable = false, columnDefinition = "TEXT")
  private String description;

  @Column(name = "add_user", nullable = false)
  private Long addUser;

  @Column(name = "last_mod", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModified;

  // Constructors, getters, and setters
}
