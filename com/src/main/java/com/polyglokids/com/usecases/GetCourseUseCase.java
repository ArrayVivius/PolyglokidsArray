package com.polyglokids.com.usecases;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyglokids.com.DTOs.course.CourseWithLessonRes;
import com.polyglokids.com.persistence.models.course.CourseDao;
import com.polyglokids.com.persistence.models.course.CourseModel;

/**
 * getCourseUseCase
 */
@Service
public class GetCourseUseCase {
  @Autowired
  private CourseDao courseDao;

  public Optional<CourseModel> GetCourseByIdWithAllLesson(String id) throws Exception {

    CourseWithLessonRes res = new CourseWithLessonRes();
    Optional<CourseModel> course = courseDao.findById(id);
    if (course == null) {
      throw new Exception("Curso no encontrado con el ID: " + id);
    }
    return course;
  }
}
