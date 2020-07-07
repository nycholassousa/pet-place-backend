package com.petplace.placeservice.payload;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class CreatePlaceRequest {

    @NotNull(message = "{place.user.null}")
    private Integer userId;

    @NotEmpty(message = "{place.name.empty}")
    private String name;

    @NotNull(message = "{place.latitude.null}")
    private long latitude;

    @NotNull(message = "{place.longitude.null}")
    private long longitude;

    @NotNull(message = "{place.internalArea.empty}")
    private boolean internalArea;
}
