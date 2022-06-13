package com.localsearch.places.controller.mapper;

import com.localsearch.places.controller.dto.PlaceDTO;
import com.localsearch.places.controller.dto.WorkIntervalDTO;
import com.localsearch.places.model.Place;
import com.localsearch.places.model.WorkInterval;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Mapping specification for {@link Place} -> {@link PlaceDTO}
 */
@Mapper
public abstract class PlaceToPlaceDTOMapper {

    public static PlaceToPlaceDTOMapper MAPPER
            = Mappers.getMapper(PlaceToPlaceDTOMapper.class);


    @Mappings({
            @Mapping(target = "start", dateFormat = "HH:mm"),
            @Mapping(target = "end", dateFormat = "HH:mm"),
    })
    abstract WorkIntervalDTO toDomainObject(WorkInterval source);

    public abstract PlaceDTO placeToPlaceDto(Place source);
}
