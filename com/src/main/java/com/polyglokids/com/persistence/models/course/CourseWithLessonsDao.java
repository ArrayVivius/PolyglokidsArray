package com.polyglokids.com.persistence.models.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseWithLessonsDao extends JpaRepository<CourseModel, String> {
  List<Object[]> findCourseWithLessonsById(String courseId);
}
