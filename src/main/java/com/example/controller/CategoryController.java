package com.example.controller;

import com.example.exception.CategoryNotFoundException;
import com.example.models.CategoryEntity;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  /**
   * Get all categories.
   *
   * @return ResponseEntity with List of CategoryEntity objects.
   */
  @GetMapping
  public ResponseEntity<List<CategoryEntity>> getAllCategories() {
    try {
      List<CategoryEntity> categories = categoryService.getAllCategories();
      return ResponseEntity.ok(categories);
    } catch (Exception e) {
      // Log the exception
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  /**
   * Get a category by its ID.
   *
   * @param id The ID of the category.
   * @return ResponseEntity with the CategoryEntity object.
   */
  @GetMapping("/{id}")
  public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable("id") Long id) {
    try {
      CategoryEntity category = categoryService.getCategoryById(id);
      return ResponseEntity.ok(category);
    } catch (CategoryNotFoundException e) {
      // Log the exception
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } catch (Exception e) {
      // Log the exception
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  // Add more controller methods for handling other endpoints
}
