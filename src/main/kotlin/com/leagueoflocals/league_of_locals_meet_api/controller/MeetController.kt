package com.leagueoflocals.league_of_locals_meet_api.controller

import com.leagueoflocals.league_of_locals_meet_api.model.Course
import com.leagueoflocals.league_of_locals_meet_api.service.CourseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/v1/meets")
class MeetController (
) {

    @GetMapping("/{meetId}")
    fun getUserProfile(@PathVariable meetId: UUID): ResponseEntity<String> {
        return "Meet details for meet ID: $meetId".let { ResponseEntity.ok(it) }
    }
}