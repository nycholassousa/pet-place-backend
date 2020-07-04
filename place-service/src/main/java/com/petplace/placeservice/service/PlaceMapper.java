package com.petplace.placeservice.service;

import com.petplace.placeservice.model.Place;
import com.petplace.placeservice.payload.CreatePlaceRequest;
import org.mapstruct.Mapper;

@Mapper
public interface PlaceMapper {
    Place createPlaceRequestToPlace(CreatePlaceRequest createPlaceRequest);
}
