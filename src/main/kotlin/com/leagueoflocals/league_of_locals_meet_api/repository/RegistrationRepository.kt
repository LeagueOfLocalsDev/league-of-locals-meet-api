package com.leagueoflocals.league_of_locals_meet_api.repository

import com.leagueoflocals.league_of_locals_meet_api.model.Registration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RegistrationRepository : JpaRepository<Registration, UUID>
