package com.localsearch.places.model;

import lombok.Data;

import java.time.LocalTime;

/**
 * Work Interval model class
 */
@Data
public class WorkInterval {
    private LocalTime start;
    private LocalTime end;
    private String type;

}
