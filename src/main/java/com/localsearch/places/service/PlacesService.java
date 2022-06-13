package com.localsearch.places.service;

import com.localsearch.places.model.Place;
import com.localsearch.places.repo.PlacesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlacesService {

    private final PlacesRepo placesRepo;

    /**
     * Retrieves Place by id
     *
     * @param id
     * @return {@link Place}
     */
    public Place getById(String id) {
        return placesRepo.getById(id);
    }


}
