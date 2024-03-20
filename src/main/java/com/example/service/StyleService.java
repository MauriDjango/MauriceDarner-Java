package com.example.service;

import com.example.exception.StyleNotFoundException;
import com.example.models.StyleEntity;
import com.example.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling style-related operations.
 */
@Service
public class StyleService {

  private final StyleRepository styleRepository;

  /**
   * Constructs a StyleService with the given StyleRepository.
   *
   * @param styleRepository The repository for accessing style data.
   */
  @Autowired
  public StyleService(StyleRepository styleRepository) {
    this.styleRepository = styleRepository;
  }

  /**
   * Retrieves all styles.
   *
   * @return A list of all styles.
   * @throws RuntimeException If an error occurs while retrieving the styles.
   */
  public List<StyleEntity> getAllStyles() {
    try {
      return styleRepository.findAll();
    } catch (Exception e) {
      // Log the exception
      throw new RuntimeException("Error retrieving all styles", e);
    }
  }

  /**
   * Retrieves a style by its ID.
   *
   * @param id The ID of the style to retrieve.
   * @return The style entity with the given ID.
   * @throws StyleNotFoundException If no style is found with the given ID.
   */
  public StyleEntity getStyleById(Long id) {
    return styleRepository.findById(id)
        .orElseThrow(() -> new StyleNotFoundException("Style not found with id: " + id));
  }

  // Add more service methods as needed
}
