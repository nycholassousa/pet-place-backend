package com.petplace.placeservice.repository;

import com.petplace.placeservice.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    boolean existsByLatitudeAndLongitude(long latitude, long longitude);

    List<Place> findAllByUserId(Integer userId);

    @Query("select distinct p from Place p where sqrt(power(p.latitude - :latitude, 2) + power(p.longitude - :longitude, 2)) <= :maxDistance")
    List<Place> findAllByCoordinate(@Param("latitude") long latitude, @Param("longitude") Long longitude, @Param("maxDistance") Double maxDistance);
}
