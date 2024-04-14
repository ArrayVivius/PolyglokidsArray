package com.polyglokids.com.persistence.models.course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface CourseDao extends JpaRepository<CourseModel, String> {
  Optional<CourseModel> findById(String username);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO  course_alumno_mapping (course_id, alumno_id) VALUES (?1, ?2)", nativeQuery = true)

  void assignAlumnoToCourse(String courseId, String alumnoId);
}
