package com.polyglokids.com.persistence.models.lesson;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface LessonDao extends CrudRepository<LessonModel, String> {
  Optional<LessonModel> findByNombre(String username);
}
