package com.petplace.placeservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "place")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uuid", nullable = false, unique = true)
    private final UUID uuid = UUID.randomUUID();

    @Column(name = "user_id", nullable = false, unique = false)
    private Integer userId;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "latitude", nullable = false, unique = false)
    private long latitude;

    @Column(name = "longitude", nullable = false, unique = false)
    private long longitude;

    @Column(name = "internal_area", nullable = false, unique = false)
    private boolean internalArea;
}
