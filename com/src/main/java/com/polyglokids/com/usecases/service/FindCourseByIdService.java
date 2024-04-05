package com.polyglokids.com.usecases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.polyglokids.com.persistence.models.course.CourseDao;
import com.polyglokids.com.persistence.models.course.CourseModel;

@Component
public class FindCourseByIdService {

  @Autowired
  private CourseDao courseDao;

  public CourseModel loadCourseById(String id) {
    CourseModel course = courseDao.findById(id).orElse(null);
    return course;
  }

}
