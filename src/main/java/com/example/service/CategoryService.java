package com.example.service;

import com.example.exception.CategoryNotFoundException;
import com.example.models.CategoryEntity;
import com.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling category-related operations.
 */
@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  /**
   * Constructs a CategoryService with the given CategoryRepository.
   *
   * @param categoryRepository The repository for accessing category data.
   */
  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  /**
   * Retrieves all categories.
   *
   * @return A list of all categories.
   * @throws RuntimeException If an error occurs while retrieving the categories.
   */
  public List<CategoryEntity> getAllCategories() {
    try {
      return categoryRepository.findAll();
    } catch (Exception e) {
      // Log the exception
      throw new RuntimeException("Error retrieving all categories", e);
    }
  }

  /**
   * Retrieves a category by its ID.
   *
   * @param id The ID of the category to retrieve.
   * @return The category entity with the given ID.
   * @throws CategoryNotFoundException If no category is found with the given ID.
   */
  public CategoryEntity getCategoryById(Long id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
  }

  // Add more service methods as needed
}
