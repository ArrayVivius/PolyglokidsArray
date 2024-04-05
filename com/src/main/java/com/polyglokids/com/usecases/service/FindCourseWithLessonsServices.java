package com.polyglokids.com.usecases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.course.CourseWithLessonsDao;

@Component
public class FindCourseWithLessonsServices {

  @Autowired
  private CourseWithLessonsDao courseWithLessonsDao;

  public List<Object[]> loadCourseBylessons(String id) {
    List<Object[]> course = courseWithLessonsDao.findCourseWithLessonsById(id);
    return course;

  }
}
