package com.petplace.placeservice.controller;

import com.petplace.placeservice.model.Place;
import com.petplace.placeservice.payload.CreatePlaceRequest;
import com.petplace.placeservice.service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<Place> getPlaceById(@PathVariable Integer id) {
        Place place = placeService.getPlaceById(id);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }
}
