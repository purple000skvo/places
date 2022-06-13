package com.localsearch.places.repo.externalapi.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * External Api Opening Hours DTO
 */
@Data
public class OpeningHoursExternalDTO {
    private Map<String, List<WorkIntervalExternalDTO>> days;
}
