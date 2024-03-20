package com.example.service;

import com.example.exception.BeerNotFoundException;
import com.example.models.BeerEntity;
import com.example.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling beer-related operations.
 */
@Service
public class BeerService {

  private final BeerRepository beerRepository;

  /**
   * Constructs a BeerService with the given BeerRepository.
   *
   * @param beerRepository The repository for accessing beer data.
   */
  @Autowired
  public BeerService(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  /**
   * Retrieves all beers.
   *
   * @return A list of all beers.
   * @throws RuntimeException If an error occurs while retrieving the beers.
   */
  public List<BeerEntity> getAllBeers() {
    try {
      return beerRepository.findAll();
    } catch (Exception e) {
      // Log the exception
      throw new RuntimeException("Error retrieving all beers", e);
    }
  }

  /**
   * Creates a new beer.
   *
   * @param beer The beer entity to create.
   * @return The created beer entity.
   * @throws RuntimeException If an error occurs while creating the beer.
   */
  public BeerEntity createBeer(BeerEntity beer) {
    try {
      return beerRepository.save(beer);
    } catch (Exception e) {
      // Log the exception
      throw new RuntimeException("Error creating beer", e);
    }
  }

  /**
   * Retrieves a beer by its ID.
   *
   * @param id The ID of the beer to retrieve.
   * @return The beer entity with the given ID.
   * @throws BeerNotFoundException If no beer is found with the given ID.
   */
  public BeerEntity getBeerById(Long id) {
    return beerRepository.findById(id)
        .orElseThrow(() -> new BeerNotFoundException("Beer not found with id: " + id));
  }

  /**
   * Deletes a beer by its ID.
   *
   * @param id The ID of the beer to delete.
   */
  public void deleteBeerById(Long id) {
    beerRepository.deleteById(id);
  }

  /**
   * Updates a beer.
   *
   * @param id   The ID of the beer to update.
   * @param beer The updated beer entity.
   * @return The updated beer entity.
   * @throws BeerNotFoundException If no beer is found with the given ID.
   */
  public BeerEntity updateBeer(Long id, BeerEntity beer) {
    if (beerRepository.existsById(id)) {
      beer.setId(id);
      return beerRepository.save(beer);
    } else {
      throw new BeerNotFoundException("Beer not found with id: " + id);
    }
  }
}
