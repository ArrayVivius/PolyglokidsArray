package com.polyglokids.com.domain.entities.types.homework;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HomeWorkDTO {
  @NotNull(message = "Es necesario agregar un ID")
  @NotBlank(message = "El ID no puede estar en blanco")
  private String id;

  @NotNull(message = "Es necesario agregar un nombre")
  @NotBlank(message = "El nombre no puede estar en blanco")
  private String nombre;

  @NotNull(message = "Es necesario agregar una fecha de entrega")
  private LocalDate fecha;

  @NotNull(message = "Es necesario especificar la lección")
  private String leccion;
}
