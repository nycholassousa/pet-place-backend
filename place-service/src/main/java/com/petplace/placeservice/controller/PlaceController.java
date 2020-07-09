package com.petplace.placeservice.controller;

import com.petplace.placeservice.model.Place;
import com.petplace.placeservice.payload.CreatePlaceRequest;
import com.petplace.placeservice.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/place")
@AllArgsConstructor
@Slf4j
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
    public ResponseEntity<Place> getPlaceById(@PathVariable("id") Integer placeId, HttpServletRequest request) {
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
    public ResponseEntity<List<Place>> getPlacesByPositionAndDistance(@PathVariable("lat") long latitude, @PathVariable("lng") long longitude, @PathVariable double distance) {
        List<Place> placeList = placeService.getAllPlacesByCoordinateAndDistance(latitude, longitude, distance);
        return new ResponseEntity<>(placeList, HttpStatus.OK);
    }
}
