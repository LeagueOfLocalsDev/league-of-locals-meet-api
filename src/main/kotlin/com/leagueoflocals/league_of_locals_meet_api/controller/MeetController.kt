package com.leagueoflocals.league_of_locals_meet_api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/v1/meets")
class MeetController {

    @GetMapping("/{meetId}")
    fun getMeet(@PathVariable meetId: UUID): String {
        return "Meet details for meetId: $meetId"
    }
}