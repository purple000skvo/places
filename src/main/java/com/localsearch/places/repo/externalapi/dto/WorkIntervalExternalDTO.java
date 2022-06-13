package com.localsearch.places.repo.externalapi.dto;

import lombok.Data;

/**
 * External Api Work Interval DTO
 */
@Data
public class WorkIntervalExternalDTO {
    private String start;
    private String end;
    private String type;
}
