package com.polyglokids.com.domain.entities.types.lesson;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LessonDTO {
  @NotNull(message = "Es necesario agregar un nombre")
  @NotBlank(message = "El nombre no puede estar en blanco")
  private String nombre;

  @NotNull(message = "Es necesario agregar una fecha")
  private LocalDate fecha;

  @NotNull(message = "Es necesario agregar un número de lección")
  @Positive(message = "El número de lección debe ser positivo")
  private Integer numero_de_leccion;

  @NotNull(message = "Es necesario agregar un tema")
  @NotBlank(message = "El tema no puede estar en blanco")
  private String tema;

  private String nota;

  @NotNull(message = "Es necesario agregar un link de la calse")
  @NotBlank(message = "El link no puede estar en blanco")
  private String link;

  @NotNull(message = "Es necesario especificar el curso")
  private String curso;

}
