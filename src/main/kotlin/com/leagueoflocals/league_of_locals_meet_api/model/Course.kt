package com.leagueoflocals.league_of_locals_meet_api.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "course")
data class Course(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val distanceMeters: Int,
    @Column(nullable = true)
    val mapImageUrl: String? = null,
    @Column(nullable = false)
    val startCoordinates: Coordinates,
)
