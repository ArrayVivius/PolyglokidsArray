package com.polyglokids.com.persistence.models.course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<CourseModel, String> {
  Optional<CourseModel> findById(String username);
}
