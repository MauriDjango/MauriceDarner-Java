package com.example.service;

import com.example.exception.BreweryNotFoundException;
import com.example.models.BreweryEntity;
import com.example.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling brewery-related operations.
 */
@Service
public class BreweryService {

  private final BreweryRepository breweryRepository;

  /**
   * Constructs a BreweryService with the given BreweryRepository.
   *
   * @param breweryRepository The repository for accessing brewery data.
   */
  @Autowired
  public BreweryService(BreweryRepository breweryRepository) {
    this.breweryRepository = breweryRepository;
  }

  /**
   * Retrieves all breweries.
   *
   * @return A list of all breweries.
   * @throws RuntimeException If an error occurs while retrieving the breweries.
   */
  public List<BreweryEntity> getAllBreweries() {
    try {
      return breweryRepository.findAll();
    } catch (Exception e) {
      // Log the exception
      throw new RuntimeException("Error retrieving all breweries", e);
    }
  }

  /**
   * Retrieves a brewery by its ID.
   *
   * @param id The ID of the brewery to retrieve.
   * @return The brewery entity with the given ID.
   * @throws BreweryNotFoundException If no brewery is found with the given ID.
   */
  public BreweryEntity getBreweryById(Long id) {
    Optional<BreweryEntity> optionalBrewery = breweryRepository.findById(id);
    if (optionalBrewery.isPresent()) {
      return optionalBrewery.get();
    } else {
      throw new BreweryNotFoundException("Brewery not found with id: " + id);
    }
  }

  // Add more service methods as needed
}
