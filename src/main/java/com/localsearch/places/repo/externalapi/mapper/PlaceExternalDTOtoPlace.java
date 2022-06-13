package com.localsearch.places.repo.externalapi.mapper;

import com.localsearch.places.model.OpeningHours;
import com.localsearch.places.model.Place;
import com.localsearch.places.model.WorkInterval;
import com.localsearch.places.repo.externalapi.dto.OpeningHoursExternalDTO;
import com.localsearch.places.repo.externalapi.dto.PlaceExternalDTO;
import com.localsearch.places.repo.externalapi.dto.WorkIntervalExternalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapping specification for {@link PlaceExternalDTO} -> {@link Place}
 */
@Mapper
public abstract class PlaceExternalDTOtoPlace {

    public static final PlaceExternalDTOtoPlace mapper
            = Mappers.getMapper(PlaceExternalDTOtoPlace.class);

    abstract WorkInterval toDomainObject(WorkIntervalExternalDTO source);

    abstract List<WorkInterval> toDomainObject(List<WorkIntervalExternalDTO> source);

    @Mappings({
            @Mapping(target = "monday", expression = "java(convertDay(source, \"monday\"))"),
            @Mapping(target = "tuesday", expression = "java(convertDay(source, \"tuesday\"))"),
            @Mapping(target = "wednesday", expression = "java(convertDay(source, \"wednesday\"))"),
            @Mapping(target = "thursday", expression = "java(convertDay(source, \"thursday\"))"),
            @Mapping(target = "friday", expression = "java(convertDay(source, \"friday\"))"),
            @Mapping(target = "saturday", expression = "java(convertDay(source, \"saturday\"))"),
            @Mapping(target = "sunday", expression = "java(convertDay(source, \"sunday\"))")
    })
    abstract OpeningHours toDomainObject(OpeningHoursExternalDTO source);

    List<WorkInterval> convertDay(OpeningHoursExternalDTO source, String day) {
        if (source.getDays().get(day) == null) {
            return null;
        }
        return toDomainObject(source.getDays().get(day));
    }

    @Mappings({
            @Mapping(target = "name", source = "displayedWhat"),
            @Mapping(target = "address", source = "displayedWhere"),
    })
    public abstract Place placeDtoToPlace(PlaceExternalDTO source);

}
