package com.localsearch.places.repo.externalapi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * External Api Place DTO
 */
@Data
public class PlaceExternalDTO implements Serializable {
    private String displayedWhat;
    private String displayedWhere;
    private OpeningHoursExternalDTO openingHours;
}
