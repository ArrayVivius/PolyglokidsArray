package com.polyglokids.com.domain.entities.types.course;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CourseDTO {
  @NotNull(message = "Es necesario agregar un nombre")
  @NotBlank(message = "El nombre no puede estar en blanco")
  private String nombre;

  @NotNull(message = "Es necesario agregar una descripción")
  @NotBlank(message = "La descripción no puede estar en blanco")
  private String descripcion;

  @NotNull(message = "Es necesario agregar un profesor")
  @NotBlank(message = "El profesor no puede estar en blanco")
  private String profesor;

  @NotNull(message = "Es necesario agregar un idioma")
  @NotBlank(message = "El idioma no puede estar en blanco")
  private String idioma;

  private Set<String> alumnos; // Cambiado a Set<String> en lugar de List<String>

  @NotNull(message = "Es necesario agregar un número de clase")
  @Positive(message = "El número de clase no puede estar en blanco")
  private Integer numeroDeClase;
}
