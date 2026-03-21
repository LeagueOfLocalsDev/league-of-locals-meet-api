package com.leagueoflocals.league_of_locals_meet_api.service

import com.leagueoflocals.league_of_locals_meet_api.controller.CreateMeetRequest
import com.leagueoflocals.league_of_locals_meet_api.model.Meet
import com.leagueoflocals.league_of_locals_meet_api.repository.MeetRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.time.OffsetDateTime

@ExtendWith(MockitoExtension::class)
class MeetServiceTest {

    private val meetRepository: MeetRepository = mock()
    private val service = MeetService(meetRepository)

    @Test
    fun `createMeet saves organizerAuth0Id and parses scheduledTimeUtc`() {
        val request = CreateMeetRequest(
            name = "Test Meet",
            scheduledTimeUtc = "2024-03-07T12:34:56Z",
            status = "OPEN",
            unitStandard = "STANDARD",
            maxParticipants = 5
        )

        given(meetRepository.save(any<Meet>())).willAnswer { invocation -> invocation.arguments[0] as Meet }

        val organizerId = "auth0|user123"
        val saved = service.createMeet(request, organizerId)

        assertEquals(organizerId, saved.organizerAuth0Id)
        assertEquals(request.name, "name")
        assertEquals(5, saved.maxParticipants)
        assertEquals(OffsetDateTime.parse(request.scheduledTimeUtc), saved.scheduledTimeUtc)

        verify(meetRepository).save(any())
    }

    @Test
    fun `createMeet accepts offset time format with zone offset`() {
        val timeWithOffset = "2024-03-07T12:34:56+02:00"
        val request = CreateMeetRequest(
            name = "Offset Meet",
            scheduledTimeUtc = timeWithOffset,
            status = "OPEN",
            unitStandard = "STANDARD",
            maxParticipants = null
        )

        given(meetRepository.save(any<Meet>())).willAnswer { invocation -> invocation.arguments[0] as Meet }

        val saved = service.createMeet(request, "auth0|offsetUser")

        assertEquals(OffsetDateTime.parse(timeWithOffset), saved.scheduledTimeUtc)
    }
}