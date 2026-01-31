package com.leagueoflocals.league_of_locals_meet_api.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "registration")
data class Registration(
    @Id
    val id: String,
    @Column(nullable = false)
    val meetId: String,
    @Column(nullable = false)
    val runnerAuth0Id: String,
    @Column(nullable = false)
    val registeredAt: String,
    @Column(nullable = false)
    val status: String,
)