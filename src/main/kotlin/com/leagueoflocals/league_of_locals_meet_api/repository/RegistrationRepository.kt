package com.leagueoflocals.league_of_locals_meet_api.repository

import com.leagueoflocals.league_of_locals_meet_api.model.Registration
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RegistrationRepository : JpaRepository<Registration, UUID>
