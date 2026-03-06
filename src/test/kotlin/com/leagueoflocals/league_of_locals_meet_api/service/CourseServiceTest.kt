package com.leagueoflocals.league_of_locals_meet_api.service

import com.leagueoflocals.league_of_locals_meet_api.repository.CourseRepository
import com.leagueoflocals.league_of_locals_meet_api.controller.CreateCourseRequest
import com.leagueoflocals.league_of_locals_meet_api.model.Course
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.given
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
class CourseServiceTest {
    @Mock
    private lateinit var courseRepository: CourseRepository

    @InjectMocks
    private lateinit var courseService: CourseService

    @Test
    fun `when createCourse is called with valid data, it should save the course to the database`() {
        val request = CreateCourseRequest(
            name = "Epic Test Course",
            distanceMeters = 5000,
            mapImageUrl = "http://example.com/map.png",
            startCoordinates = null
        )

        val createdCourse = Course(
            name = request.name,
            distanceMeters = request.distanceMeters,
            mapImageUrl = request.mapImageUrl,
            startCoordinates = request.startCoordinates
        )

        given(courseRepository.save(any<Course>())).willReturn(createdCourse)

        val result = courseService.createCourse(request)

        verify(courseRepository).save(any<Course>())

        assertThat(result).isNotNull()
        assertThat(result.name).isEqualTo(request.name)
        assertThat(result.distanceMeters).isEqualTo(request.distanceMeters)
        assertThat(result.mapImageUrl).isEqualTo(request.mapImageUrl)
    }
    @Test
    fun `when getCourse is called with an existing course ID, it should return the course`() {
        val courseId = java.util.UUID.randomUUID()
        val existingCourse = Course(
            id = courseId,
            name = "Existing Course",
            distanceMeters = 10000,
            mapImageUrl = "http://example.com/existing_map.png",
            startCoordinates = null
        )

        given(courseRepository.findById(courseId)).willReturn(java.util.Optional.of(existingCourse))

        val result = courseService.getCourse(courseId)

        verify(courseRepository).findById(courseId)

        assertThat(result).isNotNull()
        assertThat(result?.id).isEqualTo(courseId)
        assertThat(result?.name).isEqualTo(existingCourse.name)
    }

    @Test
    fun `when getCourse is called with a non-existing course ID, it should return null`() {
        val courseId = java.util.UUID.randomUUID()

        given(courseRepository.findById(courseId)).willReturn(java.util.Optional.empty())

        val result = courseService.getCourse(courseId)

        verify(courseRepository).findById(courseId)

        assertThat(result).isNull()
    }
}