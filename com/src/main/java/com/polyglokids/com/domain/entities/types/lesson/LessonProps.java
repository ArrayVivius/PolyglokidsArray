package com.polyglokids.com.domain.entities.types.lesson;

import java.time.LocalDate;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * LessonProps
 */
@Builder
@Getter
@Setter
public class LessonProps {

  String nombre;
  LocalDate fecha;
  Integer numero_de_leccion;
  String tema;
  String nota;
  String descripcion;
  String profesor;
  String idioma;
  Set<String> alumnos; // Cambiado a Set<String> en lugar de List<String>
  String link;
  String curso;
}
