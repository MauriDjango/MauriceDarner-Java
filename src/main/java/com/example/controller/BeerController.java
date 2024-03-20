package com.example.controller;

import com.example.dto.BeerDTO;
import com.example.models.BeerEntity;
import com.example.service.BeerService;
import java.lang.reflect.Field;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling beer-related endpoints.
 */
@RestController
@RequestMapping("/beers")
public class BeerController {

  private final BeerService beerService;

  @Autowired
  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }

  /**
   * Retrieves all beers.
   *
   * @return A list of all beers.
   */
  @GetMapping
  public List<BeerEntity> getAllBeers() {
    try {
      return beerService.getAllBeers();
    } catch (Exception e) {
      // Log the exception
      return null;
    }
  }

  /**
   * Creates a new beer.
   *
   * @param beerDTO The beer data to create.
   * @return The created beer entity.
   */
  @PostMapping("/beer")
  public BeerEntity createBeer(@RequestBody BeerDTO beerDTO) {
    try {
      BeerEntity beer = new BeerEntity();
      // Map data from BeerDTO to BeerEntity

      beer.setId(beerDTO.getId());
      beer.setBreweryId(beerDTO.getBreweryId());
      beer.setName(beerDTO.getName());
      beer.setCatId(beerDTO.getCatId());
      beer.setStyleId(beerDTO.getStyleId());
      beer.setAbv(beerDTO.getAbv());
      beer.setIbu(beerDTO.getIbu());
      beer.setSrm(beerDTO.getSrm());
      beer.setUpc(beerDTO.getUpc());
      beer.setFilePath(beerDTO.getFilePath());
      beer.setDescription(beerDTO.getDescription());
      beer.setAddUser(beerDTO.getAddUser());
      beer.setLastModified(beerDTO.getLastModified());
      // Set other properties as needed

      return beerService.createBeer(beer);
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
   */
  @GetMapping("/{id}")
  public BeerEntity getBeerById(@PathVariable("id") Long id) {
    try {
      return beerService.getBeerById(id);
    } catch (Exception e) {
      // Log the exception
      throw new RuntimeException("Error retrieving beer", e);
    }
  }

  /**
   * Deletes a beer by its ID.
   *
   * @param id The ID of the beer to delete.
   */
  @DeleteMapping("/{id}")
  public void deleteBeerById(@PathVariable("id") Long id) {
    try {
      beerService.deleteBeerById(id);
    } catch (Exception e) {
      // Log the exception
      throw new RuntimeException("Error deleting beer", e);
    }
  }

  /**
   * Updates a beer.
   *
   * @param id     The ID of the beer to update.
   * @param beerDTO The updated beer data.
   * @return The updated beer entity.
   */
  @PutMapping("/{id}")
  public BeerEntity updateBeer(@PathVariable("id") Long id, @RequestBody BeerDTO beerDTO) {
    try {
      BeerEntity beerEntity = new BeerEntity();
      // Map data from BeerDTO to BeerEntity

      beerEntity.setId(beerDTO.getId());
      beerEntity.setBreweryId(beerDTO.getBreweryId());
      beerEntity.setName(beerDTO.getName());
      beerEntity.setCatId(beerDTO.getCatId());
      beerEntity.setStyleId(beerDTO.getStyleId());
      beerEntity.setAbv(beerDTO.getAbv());
      beerEntity.setIbu(beerDTO.getIbu());
      beerEntity.setSrm(beerDTO.getSrm());
      beerEntity.setUpc(beerDTO.getUpc());
      beerEntity.setFilePath(beerDTO.getFilePath());
      beerEntity.setDescription(beerDTO.getDescription());
      beerEntity.setAddUser(beerDTO.getAddUser());
      beerEntity.setLastModified(beerDTO.getLastModified());
      // Set other properties as needed

      return beerService.updateBeer(id, beerEntity);
    } catch (Exception e) {
      // Log the exception
      throw new RuntimeException("Error updating beer", e);
    }
  }

  /**
   * Updates a beer partially.
   *
   * @param id     The ID of the beer to update.
   * @param beerDTO The updated beer data.
   * @return The updated beer entity.
   */
  @PatchMapping("/{id}")
  public BeerEntity updateBeerPartial(@PathVariable("id") Long id, @RequestBody BeerDTO beerDTO)
      throws IllegalAccessException {
    try {
      BeerEntity beerEntity = beerService.getBeerById(id);
      updateFields(beerEntity, beerDTO);
      return beerService.updateBeer(id, beerEntity);
    } catch (Exception e) {
      // Log the exception
      throw new RuntimeException("Error updating beer", e);
    }
  }

  /**
   * Updates the fields of a BeerEntity with the non-null fields of a BeerDTO.
   *
   * @param beerEntity The beer entity to update.
   * @param beerDTO    The beer data to update.
   */
  private void updateFields(BeerEntity beerEntity, BeerDTO beerDTO) throws IllegalAccessException {
    Field[] dtoFields = beerDTO.getClass().getDeclaredFields();

    // Set all fields accessible for the loop
    for (Field field : dtoFields) {
      field.setAccessible(true);
      Object value = field.get(beerDTO);

      if (value != null) {
        String name = field.getName();
        try {
          // Get the corresponding field in the BeerEntity class
          Field entityField = BeerEntity.class.getDeclaredField(name);
          entityField.setAccessible(true);
          // Set the field value in the beerEntity
          entityField.set(beerEntity, value);
          entityField.setAccessible(false);
        } catch (NoSuchFieldException e) {
          // Log or handle the case where the field doesn't exist in BeerEntity
          System.err.println("Field not found in BeerEntity: " + name);
        }
      }
    }
  }

  // Add more controller methods for handling other endpoints
}
