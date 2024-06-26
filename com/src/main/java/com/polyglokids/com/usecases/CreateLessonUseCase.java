package com.polyglokids.com.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyglokids.com.domain.entities.LessonEntity;
import com.polyglokids.com.domain.entities.types.lesson.LessonDTO;
import com.polyglokids.com.persistence.models.course.CourseDao;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.lesson.LessonDao;
import com.polyglokids.com.persistence.models.lesson.LessonModel;

@Service
public class CreateLessonUseCase {

  @Autowired
  private LessonDao lessonDao;

  @Autowired
  private CourseDao courseDao;

  public LessonModel save(LessonDTO prop) throws Exception {
    CourseModel courseModel = courseDao.findById(prop.getCurso())
        .orElseThrow(() -> new RuntimeException("No se encontró ningún curso con el ID proporcionado"));
    if (courseModel == null) {
      throw new Exception("no existe el curso");
    }
    LessonEntity lessonEntity = LessonEntity.create(prop);

    LessonModel lessonModel = lessonDao.save(convertEntityToModel(lessonEntity,
        courseModel));
    return lessonModel;
  }

  private LessonModel convertEntityToModel(LessonEntity lessonEntity, CourseModel course) {

    LessonModel lessonModel = new LessonModel();
    lessonModel.setId(lessonEntity.getId());
    lessonModel.setNombre(lessonEntity.getLessonProps().getNombre());
    lessonModel.setFecha(lessonEntity.getLessonProps().getFecha());
    lessonModel.setNumero_de_leccion(lessonEntity.getLessonProps().getNumero_de_leccion());
    lessonModel.setTema(lessonEntity.getLessonProps().getTema());
    lessonModel.setNota(lessonEntity.getLessonProps().getNota());
    lessonModel.setLink(lessonEntity.getLessonProps().getLink());
    lessonModel.setCurso(course);
    return lessonModel;
  }
}
