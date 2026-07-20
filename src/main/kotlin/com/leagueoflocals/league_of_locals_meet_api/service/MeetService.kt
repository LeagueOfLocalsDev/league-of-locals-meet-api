package com.leagueoflocals.league_of_locals_meet_api.service

import com.leagueoflocals.league_of_locals_meet_api.controller.CreateMeetRequest
import com.leagueoflocals.league_of_locals_meet_api.model.Meet
import com.leagueoflocals.league_of_locals_meet_api.model.Course
import com.leagueoflocals.league_of_locals_meet_api.repository.MeetRepository
import com.leagueoflocals.league_of_locals_meet_api.repository.CourseRepository
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class MeetService(
    private val meetRepository: MeetRepository,
    private val courseRepository: CourseRepository
) {

    fun createMeet(request: CreateMeetRequest, organizerAuth0Id: String): Meet {
        val meet = Meet(
            organizerAuth0Id = organizerAuth0Id,
            name = request.name,
            scheduledTimeUtc = OffsetDateTime.parse(request.scheduledTimeUtc),
            status = request.status,
            unitStandard = request.unitStandard,
            maxParticipants = request.maxParticipants,
        )

        // If a courseId was provided, resolve and attach the Course entity.
        request.courseId?.let { id ->
            val course = courseRepository.findById(id).orElseThrow { IllegalArgumentException("Course not found: $id") }
            meet.course = course
        }

        return meetRepository.save(meet)
    }
}