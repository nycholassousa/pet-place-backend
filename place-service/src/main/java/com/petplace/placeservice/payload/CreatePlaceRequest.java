package com.petplace.placeservice.payload;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class CreatePlaceRequest {

    @NotNull(message = "{place.user.null}")
    private Integer userId;

    @NotEmpty
    private String name;

    @NotNull
    private long latitude;

    @NotNull
    private long longitude;

    @NotEmpty
    private boolean internalArea;
}
