package com.polyglokids.com.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyglokids.com.domain.entities.HomeWorkEntity;
import com.polyglokids.com.domain.entities.types.homework.HomeWorkDTO;
import com.polyglokids.com.persistence.models.lesson.LessonDao;
import com.polyglokids.com.persistence.models.lesson.LessonModel;
import com.polyglokids.com.persistence.models.homework.HomeWorkDao;
import com.polyglokids.com.persistence.models.homework.HomeWorkModel;

@Service
public class CreateHomeworkUseCase {

  @Autowired
  private HomeWorkDao homeworkDao;

  @Autowired
  private LessonDao lessonDao;

  public HomeWorkModel save(HomeWorkDTO prop) throws Exception {
    LessonModel lessonModel = lessonDao.findById(prop.getLeccion())
        .orElseThrow(
            () -> new Exception("leccion no encontrado con el correo electrónico: " + prop.getLeccion()));
    if (lessonModel == null) {
      throw new Exception("no existe la lección");
    }
    HomeWorkEntity homeworkEntity = HomeWorkEntity.create(prop);

    HomeWorkModel homeworkModel = homeworkDao.save(convertEntityToModel(homeworkEntity, lessonModel));
    return homeworkModel;
  }

  private HomeWorkModel convertEntityToModel(HomeWorkEntity homeworkEntity, LessonModel lessonModel) {

    HomeWorkModel homeworkModel = new HomeWorkModel();
    homeworkModel.setId(homeworkEntity.getId());
    homeworkModel.setNombre(homeworkEntity.getHomeworkProps().getNombre());
    homeworkModel.setFecha(homeworkEntity.getHomeworkProps().getFecha());
    homeworkModel.setUbicacion(homeworkEntity.getHomeworkProps().getUbicacion());
    homeworkModel.setLeccion(lessonModel);
    return homeworkModel;
  }
}
