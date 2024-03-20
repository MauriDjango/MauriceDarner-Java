package com.example.controller;

import com.example.exception.StyleNotFoundException;
import com.example.models.StyleEntity;
import com.example.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/styles")
public class StyleController {

  private final StyleService styleService;

  @Autowired
  public StyleController(StyleService styleService) {
    this.styleService = styleService;
  }

  /**
   * Get all styles.
   *
   * @return ResponseEntity with List of StyleEntity objects.
   */
  @GetMapping
  public ResponseEntity<List<StyleEntity>> getAllStyles() {
    try {
      List<StyleEntity> styles = styleService.getAllStyles();
      return ResponseEntity.ok(styles);
    } catch (Exception e) {
      // Log the exception
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  /**
   * Get a style by its ID.
   *
   * @param id The ID of the style.
   * @return ResponseEntity with the StyleEntity object.
   */
  @GetMapping("/{id}")
  public ResponseEntity<StyleEntity> getStyleById(@PathVariable("id") Long id) {
    try {
      StyleEntity style = styleService.getStyleById(id);
      return ResponseEntity.ok(style);
    } catch (StyleNotFoundException e) {
      // Log the exception
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } catch (Exception e) {
      // Log the exception
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  // Add more controller methods for handling other endpoints
}
