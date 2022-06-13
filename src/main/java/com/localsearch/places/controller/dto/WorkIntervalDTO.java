package com.localsearch.places.controller.dto;

import lombok.Data;

/**
 * Web View of {@link com.localsearch.places.model.WorkInterval}
 */
@Data
public class WorkIntervalDTO {
    private String start;
    private String end;
    private String type;
}
