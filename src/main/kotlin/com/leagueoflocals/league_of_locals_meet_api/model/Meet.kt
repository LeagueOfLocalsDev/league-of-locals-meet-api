package com.leagueoflocals.league_of_locals_meet_api.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "meet")
data class Meet(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val organizerAuth0Id: String,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val scheduledTimeUtc: Date,
    @Column(nullable = false)
    val status: String,
    @Column(nullable = false)
    val unitStandard: String,
    @Column(nullable = true)
    val maxParticipants: Int? = null,
)
