package com.localsearch.places.controller.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

/**
 * Web View of {@link com.localsearch.places.model.Place}
 */
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlaceDTO implements Serializable {
    private String name;
    private String address;
    private OpeningHoursDTO openingHours;
}
