package com.localsearch.places.model;

import lombok.Data;

import java.util.List;

/**
 * Opening Hours model class
 */
@Data
public class OpeningHours {
    private List<WorkInterval> monday;
    private List<WorkInterval> tuesday;
    private List<WorkInterval> wednesday;
    private List<WorkInterval> thursday;
    private List<WorkInterval> friday;
    private List<WorkInterval> saturday;
    private List<WorkInterval> sunday;
}
