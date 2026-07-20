package com.leagueoflocals.league_of_locals_meet_api.controller
import com.leagueoflocals.league_of_locals_meet_api.service.MeetService
import jakarta.validation.Valid
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/v1/meets")
class MeetController (
        private val meetService: MeetService
) {

    @PostMapping
    fun createMeet (
        @Valid @RequestBody request: CreateMeetRequest,
        @AuthenticationPrincipal jwt: Jwt
    ) {
        meetService.createMeet(request, jwt.subject)
    }
}

data class CreateMeetRequest(
    val name: String,
    val scheduledTimeUtc: String,
    val status: String,
    val unitStandard: String,
    val maxParticipants: Int? = null,
    val courseId: java.util.UUID? = null
)