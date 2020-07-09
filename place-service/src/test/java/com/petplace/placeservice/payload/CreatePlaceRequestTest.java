package com.petplace.placeservice.payload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CreatePlaceRequestTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void testNullUserId() {
        CreatePlaceRequest request = CreatePlaceRequest.builder()
                .name("pet-place")
                .latitude(1.0)
                .longitude(1.0)
                .internalArea(true)
                .build();

        Set<ConstraintViolation<CreatePlaceRequest>> violations = validator.validate(request);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(1);
    }

    @Test
    void testEmptyName() {
        CreatePlaceRequest request = CreatePlaceRequest.builder()
                .userId(1)
                .latitude(1.0)
                .longitude(1.0)
                .internalArea(true)
                .build();

        Set<ConstraintViolation<CreatePlaceRequest>> violations = validator.validate(request);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(1);
    }

    @Test
    void testNullName() {
        CreatePlaceRequest request = CreatePlaceRequest.builder()
                .userId(1)
                .name("")
                .latitude(1.0)
                .longitude(1.0)
                .internalArea(true)
                .build();

        Set<ConstraintViolation<CreatePlaceRequest>> violations = validator.validate(request);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(1);
    }

    @Test
    void testNullLatitude() {
        CreatePlaceRequest request = CreatePlaceRequest.builder()
                .userId(1)
                .name("pet-place")
                .longitude(1.0)
                .internalArea(true)
                .build();

        Set<ConstraintViolation<CreatePlaceRequest>> violations = validator.validate(request);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(1);
    }

    @Test
    void testNullLongitude() {
        CreatePlaceRequest request = CreatePlaceRequest.builder()
                .userId(1)
                .name("pet-place")
                .latitude(1.0)
                .internalArea(true)
                .build();

        Set<ConstraintViolation<CreatePlaceRequest>> violations = validator.validate(request);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(1);
    }

    @Test
    void testNullInternalArea() {
        CreatePlaceRequest request = CreatePlaceRequest.builder()
                .userId(1)
                .name("pet-place")
                .latitude(1.0)
                .longitude(1.0)
                .build();

        Set<ConstraintViolation<CreatePlaceRequest>> violations = validator.validate(request);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(1);
    }

    @Test
    void testCorrectRequest() {
        CreatePlaceRequest request = CreatePlaceRequest.builder()
                .userId(1)
                .name("pet-place")
                .latitude(1.0)
                .longitude(1.0)
                .internalArea(true)
                .build();

        Set<ConstraintViolation<CreatePlaceRequest>> violations = validator.validate(request);
        assertThat(violations).isEmpty();
    }
}