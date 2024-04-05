package com.polyglokids.com.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyglokids.com.domain.entities.LessonEntity;
import com.polyglokids.com.domain.entities.types.lesson.LessonDTO;
import com.polyglokids.com.persistence.models.course.CourseDao;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.lesson.LessonDao;
import com.polyglokids.com.persistence.models.lesson.LessonModel;
import com.polyglokids.com.usecases.service.FindCourseByIdService;

@Service
public class CreateLessonUseCase {

  @Autowired
  private LessonDao lessonDao;

  @Autowired
  private FindCourseByIdService findCourseByIdService;

  public LessonModel save(LessonDTO prop) throws Exception {
    CourseModel courseModel = findCourseByIdService.loadCourseById(prop.getCurso());
    if (courseModel == null) {
      throw new Exception("no existe el curso");
    }
    LessonEntity lessonEntity = LessonEntity.create(prop);

    LessonModel lessonModel = lessonDao.save(convertEntityToModel(lessonEntity, prop.getCurso()));
    return lessonModel;
  }

  private LessonModel convertEntityToModel(LessonEntity lessonEntity, String course) {

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
