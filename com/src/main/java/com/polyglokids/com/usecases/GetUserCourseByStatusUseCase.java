package com.polyglokids.com.usecases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyglokids.com.DTOs.course.CourseWithLessonRes;
import com.polyglokids.com.persistence.models.course.CourseDao;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.user.CursosAlumnosMappingDao;
import com.polyglokids.com.persistence.models.user.CursosAlumnosMappingModel;

/**
 * getCourseUseCase
 */
@Service
public class GetUserCourseByStatusUseCase {

  @Autowired
  private CursosAlumnosMappingDao cursosAlumnosMappingDao;

  public Map<String, List<CourseModel>> getCoursesByUserId(String userId) {
    List<CursosAlumnosMappingModel> cursosAlumnos = cursosAlumnosMappingDao.findByUserId(userId);
    Map<String, List<CourseModel>> cursosPorEstado = new HashMap<>();

    // Inicializar listas para cada estado
    cursosPorEstado.put("progreso", new ArrayList<>());
    cursosPorEstado.put("completado", new ArrayList<>());
    cursosPorEstado.put("cancelado", new ArrayList<>());

    for (CursosAlumnosMappingModel mapping : cursosAlumnos) {
      CourseModel curso = mapping.getCurso();
      String estado = curso.getEstado_de_curso();
      // Agregar el curso a la lista correspondiente según su estado
      if (estado.equals("progreso")) {
        cursosPorEstado.get("progreso").add(curso);
      } else if (estado.equals("completado")) {
        cursosPorEstado.get("completado").add(curso);
      } else if (estado.equals("cancelado")) {
        cursosPorEstado.get("cancelado").add(curso);
      }
    }

    return cursosPorEstado;
  }
}
