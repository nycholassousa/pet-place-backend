package com.petplace.placeservice.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

    @NotNull
    private boolean internalArea;
}
