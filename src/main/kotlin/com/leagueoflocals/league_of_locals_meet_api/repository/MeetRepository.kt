package com.leagueoflocals.league_of_locals_meet_api.repository

import com.leagueoflocals.league_of_locals_meet_api.model.Meet
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MeetRepository : JpaRepository<Meet, UUID>
