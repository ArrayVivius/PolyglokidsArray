package com.polyglokids.com.usecases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyglokids.com.persistence.models.UserCourse.UserCourseModel;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.user.CursosAlumnosMappingDao;
import com.polyglokids.com.persistence.models.user.CursosAlumnosMappingModel;

/**
 * GetUserCouesesUseCase
 */
@Service
public class GetUserCouesesUseCase {

  @Autowired

  private CursosAlumnosMappingDao cursosAlumnosMappingDao;

  public List<CourseModel> getCursosByUserId(String userId) {
    List<CursosAlumnosMappingModel> cursosAlumnos = cursosAlumnosMappingDao.findByUserId(userId);
    List<CourseModel> cursos = new ArrayList<>();
    for (CursosAlumnosMappingModel mapping : cursosAlumnos) {
      cursos.add(mapping.getCurso());
    }
    return cursos;
  }
}
