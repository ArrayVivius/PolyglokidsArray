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
  Integer numero_de_clase;
  String estado_de_curso;
}
