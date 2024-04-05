package com.polyglokids.com.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyglokids.com.DTOs.course.CourseWithLessonRes;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.usecases.service.FindCourseWithLessonsServices;

/**
 * getCourseUseCase
 */
@Service
public class GetCourseUseCase {

  @Autowired
  private FindCourseWithLessonsServices fCourseWithLessonsServices;

  public List<Object[]> GetCourseByIdWithAllLesson(String id) throws Exception {

    CourseWithLessonRes res = new CourseWithLessonRes();
    System.out.println(id);
    List<Object[]> course = fCourseWithLessonsServices.loadCourseBylessons(id);
    System.out.println(course);
    if (course == null) {
      throw new Exception("Curso no encontrado con el ID: " + id);
    }
    return course;
  }
}
