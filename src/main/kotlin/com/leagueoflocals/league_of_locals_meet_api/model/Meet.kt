package com.leagueoflocals.league_of_locals_meet_api.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.time.OffsetDateTime
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
    val scheduledTimeUtc: OffsetDateTime,
    @Column(nullable = false)
    val status: String,
    @Column(nullable = false)
    val unitStandard: String,
    @Column(nullable = true)
    val maxParticipants: Int? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    var course: Course? = null,
)
