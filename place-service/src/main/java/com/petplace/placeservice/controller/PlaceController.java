package com.petplace.placeservice.controller;

import com.petplace.placeservice.model.Place;
import com.petplace.placeservice.payload.CreatePlaceRequest;
import com.petplace.placeservice.service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/place")
@AllArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @RequestMapping(method = RequestMethod.GET)
    public String getStatus() {
        return "Working.";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Place> createPlace(@Valid @RequestBody CreatePlaceRequest createPlaceRequest) {
        Place place = placeService.createPlace(createPlaceRequest);
        return new ResponseEntity<>(place, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    public ResponseEntity<Place> getPlaceById(@PathVariable("id") Integer placeId) {
        Place place = placeService.getPlaceById(placeId);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}")
    @ResponseBody
    public ResponseEntity<List<Place>> getPlacesByUserId(@PathVariable("id") Integer userId) {
        List<Place> placeList = placeService.getAllPlacesByUserId(userId);
        return new ResponseEntity<>(placeList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/latitude/{lat}/longitude/{lng}/distance/{distance}")
    @ResponseBody
    public ResponseEntity<List<Place>> getPlacesByPositionAndDistance(@PathVariable long lat, @PathVariable long lng, @PathVariable double distance) {
        List<Place> placeList = placeService.getAllPlacesByCoordinateAndDistance(lat, lng, distance);
        return new ResponseEntity<>(placeList, HttpStatus.OK);
    }
}
