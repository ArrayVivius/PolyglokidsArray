package com.polyglokids.com.persistence.models.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseWithLessonsDao extends JpaRepository<CourseModel, String> {
  @Query("SELECT c, l FROM CourseModel c LEFT JOIN LessonModel l ON c.id = l.curso WHERE c.id = :courseId")
  List<Object[]> findCourseWithLessonsById(String courseId);
}
