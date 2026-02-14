package com.leagueoflocals.league_of_locals_meet_api.controller

import com.leagueoflocals.league_of_locals_meet_api.model.Coordinates
import com.leagueoflocals.league_of_locals_meet_api.model.Course
import com.leagueoflocals.league_of_locals_meet_api.service.CourseService
import jakarta.persistence.Column
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/v1/courses")
class CourseController(
    private val courseService: CourseService
) {

    @PostMapping
    fun createCourse(@RequestBody createCourse: CreateCourseRequest): ResponseEntity<Map<String, UUID>> {
        val savedCourse = courseService.createCourse(createCourse)
        return ResponseEntity.ok(mapOf("id" to savedCourse.id))
    }

    @GetMapping("/{courseId}")
    fun getUserProfile(@PathVariable courseId: UUID): ResponseEntity<Course> {
        return courseService.getCourse(courseId)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}

data class CreateCourseRequest(
    val name: String,
    val distanceMeters: Int,
    val mapImageUrl: String?,
    val startCoordinates: Coordinates?,
)