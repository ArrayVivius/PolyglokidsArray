package com.polyglokids.com.usecases.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.polyglokids.com.persistence.models.course.CourseDao;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.course.CourseWithLessonsDao;

// @Component
// public class FindCourseWithLessonsServices {
//
// @Autowired
// private CourseDao courseWithLessonsDao;
//
// public Optional<CourseModel> loadCourseBylessons(String id) {
// Optional<CourseModel> course = courseWithLessonsDao.findById(id);
// return course;
// }
// }
