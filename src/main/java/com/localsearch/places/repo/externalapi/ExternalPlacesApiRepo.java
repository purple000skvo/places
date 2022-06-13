package com.localsearch.places.repo.externalapi;

import com.localsearch.places.model.Place;
import com.localsearch.places.repo.PlacesRepo;
import com.localsearch.places.repo.externalapi.dto.PlaceExternalDTO;
import com.localsearch.places.repo.externalapi.mapper.PlaceExternalDTOtoPlace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;

/**
 * External Places Api Client
 */
@Component
@Slf4j
public class ExternalPlacesApiRepo implements PlacesRepo {
    private final String externalPlacesApiUrl;
    private final RestTemplate restTemplate;


    public ExternalPlacesApiRepo(@Value("${external.places.api.url}") @NotBlank String externalPlacesApiUrl, RestTemplate restTemplate) {
        this.externalPlacesApiUrl = externalPlacesApiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public Place getById(String id) {
        log.info("Retrieving place from url: {}, for id: {}", externalPlacesApiUrl, id);
        PlaceExternalDTO placeDto = restTemplate.getForObject(externalPlacesApiUrl + "/{id}", PlaceExternalDTO.class, id);
        log.info("Retrieved place: {} from Fake Api", placeDto);
        return PlaceExternalDTOtoPlace.mapper.placeDtoToPlace(placeDto);
    }
}
