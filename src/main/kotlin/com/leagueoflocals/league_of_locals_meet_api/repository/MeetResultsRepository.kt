package com.leagueoflocals.league_of_locals_meet_api.repository

import com.leagueoflocals.league_of_locals_meet_api.model.Meet
import com.leagueoflocals.league_of_locals_meet_api.model.MeetResults
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import jakarta.persistence.*


interface MeetResultsRepository : JpaRepository<MeetResults, UUID>
