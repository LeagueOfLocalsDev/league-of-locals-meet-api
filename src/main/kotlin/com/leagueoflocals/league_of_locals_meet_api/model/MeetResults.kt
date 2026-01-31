package com.leagueoflocals.league_of_locals_meet_api.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "meet_results")
data class MeetResults(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(unique = true, nullable = false)
    val meetId: String,
    @Column(nullable = false)
    val runnerAuth0Id: String,
    @Column(nullable = false)
    val runnerUsername: String,
    @Column(nullable = true)
    val runnerHomeCity: String? = null,
    @Column(nullable = true)
    val runnerGender: String? = null,
    @Column(nullable = false)
    val finishTimeMs: Long,
    @Column(nullable = true)
    val submissionLink: String? = null,
    @Column(nullable = false)
    val verificationStatus: String,
)