package com.polyglokids.com.usecases;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyglokids.com.domain.entities.CourseEntity;
import com.polyglokids.com.domain.entities.UserEntity;
import com.polyglokids.com.domain.entities.types.course.CourseDTO;
import com.polyglokids.com.persistence.models.course.CourseDao;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.user.CursosAlumnosMappingDao;
import com.polyglokids.com.persistence.models.user.CursosAlumnosMappingModel;
import com.polyglokids.com.persistence.models.user.UserDao;
import com.polyglokids.com.persistence.models.user.UserModel;
import com.polyglokids.com.usecases.service.FindUserByEmailService;
import com.polyglokids.com.usecases.service.FindUserByIdService;

import jakarta.transaction.Transactional;

/**
 * CreateCouserUseCase
 */
@Service
@Transactional
public class CreateCouserUseCase {
  @Autowired
  private CourseDao courseDao;

  @Autowired
  private CursosAlumnosMappingDao cursosAlumnosMappingDao;

  @Autowired
  private FindUserByIdService findUserByIdService;

  public CourseModel save(CourseDTO prop) {

    try {
      CourseEntity couserprops = CourseEntity.create(prop);
      List<UserModel> users = findUserByIdService.findUsersByIds(prop.getAlumnos());
      CourseModel courseModel = courseDao.save(convertEntityToModel(couserprops));

      for (UserModel user : users) {
        CursosAlumnosMappingModel mapping = new CursosAlumnosMappingModel();
        mapping.setCurso(courseModel);
        mapping.setUser(user);
        cursosAlumnosMappingDao.save(mapping);
      }

      return courseModel;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error al tratar de guardar los registros");
    }
  }

  private CourseModel convertEntityToModel(CourseEntity courseEntity) {
    CourseModel courseModel = new CourseModel();
    courseModel.setId(courseEntity.getId());
    courseModel.setNombre(courseEntity.getCourseProps().getNombre());
    courseModel.setDescripcion(courseEntity.getCourseProps().getDescripcion());
    courseModel.setProfesor(courseEntity.getCourseProps().getProfesor());
    courseModel.setIdioma(courseEntity.getCourseProps().getIdioma());
    courseModel.setNumero_de_clase(courseEntity.getCourseProps().getNumero_de_clase());
    courseModel.setEstado_de_curso(courseEntity.getCourseProps().getEstado_de_curso()); // Corregido aquí
    return courseModel;
  }

}
