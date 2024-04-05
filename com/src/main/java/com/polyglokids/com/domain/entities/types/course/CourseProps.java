package com.polyglokids.com.domain.entities.types.course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@Getter
@Setter
public class CourseProps {
  String nombre;
  String descripcion;
  String profesor;
  String idioma;
  Set<String> alumnos;
  Integer numero_de_clase;
}
