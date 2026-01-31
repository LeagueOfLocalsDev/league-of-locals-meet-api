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
    val distanceMeters: Int,
    val mapImageUrl: String,
    val startCoordinates: String,
)
