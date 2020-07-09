package com.petplace.placeservice.payload;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class CreatePlaceRequest {

    @NotNull(message = "{place.user.null}")
    private Integer userId;

    @NotEmpty(message = "{place.name.empty}")
    private String name;

    @NotNull(message = "{place.latitude.null}")
    private Double latitude;

    @NotNull(message = "{place.longitude.null}")
    private Double longitude;

    @NotNull(message = "{place.internalArea.empty}")
    private Boolean internalArea;
}
