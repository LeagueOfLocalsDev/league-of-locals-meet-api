package com.leagueoflocals.league_of_locals_meet_api.model

import jakarta.persistence.Embeddable

@Embeddable
data class Coordinates(
    val latitude: Double,
    val longitude: Double
)