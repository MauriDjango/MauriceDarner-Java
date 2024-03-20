package com.example.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import lombok.Getter;

@Getter
public class BeerDTO {

  private Long id;
  private Long breweryId;
  private String name;
  private Long catId;
  private Long styleId;
  private float abv;
  private float ibu;
  private float srm;
  private Long upc;
  private String filePath;
  private String description;
  private Long addUser;

  /**
   * Get the last modified date.
   *
   * @return The last modified date as a Date object.
   */
  public Date getLastModified() {
    Date in = new Date();
    LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
    return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
  }
}
