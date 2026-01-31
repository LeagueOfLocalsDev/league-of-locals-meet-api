package com.leagueoflocals.league_of_locals_meet_api.service

import com.leagueoflocals.league_of_locals_meet_api.controller.CreateCourseRequest
import com.leagueoflocals.league_of_locals_meet_api.model.Course
import com.leagueoflocals.league_of_locals_meet_api.repository.CourseRepository
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import java.util.UUID

@Service
class CourseService (
    private val courseRepository: CourseRepository
) {
    fun createCourse(request: CreateCourseRequest): Course {
        val course = Course(
            name = request.name,
            distanceMeters = request.distanceMeters,
            mapImageUrl = request.mapImageUrl,
            startCoordinates = request.startCoordinates,
        )
        return courseRepository.save(course)
    }

    fun getCourse(id: UUID): Course? {
        return courseRepository.findById(id).orElse(null)
    }
}