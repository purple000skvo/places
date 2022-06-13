package com.localsearch.places.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * Web View of {@link com.localsearch.places.model.OpeningHours}
 */
@Data
public class OpeningHoursDTO {
    private List<WorkIntervalDTO> monday;
    private List<WorkIntervalDTO> tuesday;
    private List<WorkIntervalDTO> wednesday;
    private List<WorkIntervalDTO> thursday;
    private List<WorkIntervalDTO> friday;
    private List<WorkIntervalDTO> saturday;
    private List<WorkIntervalDTO> sunday;
}
