package com.polyglokids.com.usecases;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyglokids.com.domain.entities.CourseEntity;
import com.polyglokids.com.domain.entities.UserEntity;
import com.polyglokids.com.domain.entities.types.course.CourseDTO;
import com.polyglokids.com.persistence.models.course.CourseDao;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.user.UserDao;

/**
 * CreateCouserUseCase
 */
@Service
public class CreateCouserUseCase {

  @Autowired
  private CourseDao courseDao;

  public CourseModel save(CourseDTO prop) {

    try {
      CourseEntity couserprops = CourseEntity.create(prop);
      CourseModel couseModel = courseDao.save(convertEntityToModel(couserprops));
      return couseModel;
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
    courseModel.setAlumnos(courseEntity.getCourseProps().getAlumnos());
    return courseModel;

  }

}
