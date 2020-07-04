package com.petplace.placeservice.service;

import com.petplace.placeservice.model.Place;
import com.petplace.placeservice.payload.CreatePlaceRequest;

import java.util.List;

public interface PlaceService {
    Place createPlace(CreatePlaceRequest createPlaceRequest);
    Place getPlaceById(Integer id);
    List<Place> getAllPlacesByUserId(Integer userId);
    List<Place> getAllPlacesByCoordinateAndDistance(long latitude, long longitude, double maxDistance);
}
