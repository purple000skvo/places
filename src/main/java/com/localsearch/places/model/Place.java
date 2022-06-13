package com.localsearch.places.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Place model class
 */
@Data
public class Place implements Serializable {
    private String name;
    private String address;
    private OpeningHours openingHours;
}
