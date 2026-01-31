package com.leagueoflocals.league_of_locals_meet_api.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "meet_results")
data class MeetResults(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val meetId: String,
    @Column(nullable = false)
    val runnerAuth0Id: String,
    @Column(nullable = false)
    val runnerUsername: String,
    val runnerHomeCity: String,
    val runnerGender: String,
    @Column(nullable = false)
    val finishTimeMs: Long,
    val submissionLink: String,
    @Column(nullable = false)
    val verificationStatus: String,
)