package com.leagueoflocals.league_of_locals_meet_api.service

import com.leagueoflocals.league_of_locals_meet_api.controller.CreateMeetRequest
import com.leagueoflocals.league_of_locals_meet_api.model.Meet
import com.leagueoflocals.league_of_locals_meet_api.repository.MeetRepository
import org.springframework.stereotype.Service

@Service
class MeetService(private val meetRepository: MeetRepository) {

    fun createMeet(request: CreateMeetRequest, organizerAuth0Id: String): Meet {
        val meet = Meet(
            organizerAuth0Id = organizerAuth0Id,
            name = request.name,
            scheduledTimeUtc = java.sql.Timestamp.valueOf(request.scheduledTimeUtc),
            status = request.status,
            unitStandard = request.unitStandard,
            maxParticipants = request.maxParticipants,
        )
        return meetRepository.save(meet)
    }
}