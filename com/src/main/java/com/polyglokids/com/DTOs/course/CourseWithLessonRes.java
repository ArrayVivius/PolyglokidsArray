package com.polyglokids.com.DTOs.course;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.lesson.LessonModel;

import lombok.Data;

/**
 * CourseWithLessonRes
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseWithLessonRes {

  private CourseModel course;
  private Set<LessonModel> lessons;

}
