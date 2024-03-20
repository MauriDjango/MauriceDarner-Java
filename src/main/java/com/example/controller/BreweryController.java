package com.example.controller;

import com.example.exception.BreweryNotFoundException;
import com.example.models.BreweryEntity;
import com.example.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/breweries")
public class BreweryController {

  private final BreweryService breweryService;

  @Autowired
  public BreweryController(BreweryService breweryService) {
    this.breweryService = breweryService;
  }

  /**
   * Get all breweries.
   *
   * @return ResponseEntity with List of BreweryEntity objects.
   */
  @GetMapping
  public ResponseEntity<List<BreweryEntity>> getAllBreweries() {
    try {
      List<BreweryEntity> breweries = breweryService.getAllBreweries();
      return ResponseEntity.ok(breweries);
    } catch (Exception e) {
      // Log the exception
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  /**
   * Get a brewery by its ID.
   *
   * @param id The ID of the brewery.
   * @return ResponseEntity with the BreweryEntity object.
   */
  @GetMapping("/{id}")
  public ResponseEntity<BreweryEntity> getBreweryById(@PathVariable("id") Long id) {
    try {
      BreweryEntity brewery = breweryService.getBreweryById(id);
      return ResponseEntity.ok(brewery);
    } catch (BreweryNotFoundException e) {
      // Log the exception
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } catch (Exception e) {
      // Log the exception
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  // Add more controller methods for handling other endpoints
}
