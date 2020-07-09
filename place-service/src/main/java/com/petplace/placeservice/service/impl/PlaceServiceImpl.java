package com.petplace.placeservice.service.impl;

import com.petplace.placeservice.exception.PlaceAlreadyExistException;
import com.petplace.placeservice.exception.PlaceNotFoundException;
import com.petplace.placeservice.model.Place;
import com.petplace.placeservice.payload.CreatePlaceRequest;
import com.petplace.placeservice.repository.PlaceRepository;
import com.petplace.placeservice.service.PlaceMapper;
import com.petplace.placeservice.service.PlaceService;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public Place createPlace(CreatePlaceRequest createPlaceRequest) {
        PlaceMapper placeMapper = Mappers.getMapper(PlaceMapper.class);
        Place place = placeMapper.createPlaceRequestToPlace(createPlaceRequest);

        checkPlaceExistsByLatitudeAndLongitude(place);

        return placeRepository.save(place);
    }

    @Override
    public Place getPlaceById(Integer id) {
        return placeRepository.findById(id).orElseThrow(() -> new PlaceNotFoundException("Place with id " + id + " not found."));
    }

    @Override
    public List<Place> getAllPlacesByUserId(Integer userId) {
        return placeRepository.findAllByUserId(userId);
    }

    @Override
    public List<Place> getAllPlacesByCoordinateAndDistance(long latitude, long longitude, double maxDistance) {
        return placeRepository.findAllByCoordinate(latitude, longitude, maxDistance);
    }

    private void checkPlaceExistsByLatitudeAndLongitude(Place place) {
        if (placeRepository.existsByLatitudeAndLongitude(place.getLatitude(), place.getLongitude())) {
            throw new PlaceAlreadyExistException("This place already exists");
        }
    }
}
