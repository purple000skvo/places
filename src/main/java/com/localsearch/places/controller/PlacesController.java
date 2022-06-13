package com.localsearch.places.controller;

import com.localsearch.places.controller.dto.PlaceDTO;
import com.localsearch.places.controller.mapper.PlaceToPlaceDTOMapper;
import com.localsearch.places.model.Place;
import com.localsearch.places.service.PlacesService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * Place Api Web Layer
 */

@RestController
@RequestMapping("/places")
@AllArgsConstructor
@Validated
public class PlacesController {

    private final PlacesService placesService;


    @GetMapping("/{id}")
    public PlaceDTO getById(@PathVariable("id") @NotBlank String id) {
        Place place = placesService.getById(id);
        return convertToDto(place);
    }

    private PlaceDTO convertToDto(Place place) {
        return PlaceToPlaceDTOMapper.MAPPER.placeToPlaceDto(place);
    }
}
