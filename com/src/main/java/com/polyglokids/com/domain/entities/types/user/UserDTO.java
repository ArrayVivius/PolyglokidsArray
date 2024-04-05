package com.polyglokids.com.domain.entities.types.user;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
  @NotNull(message = "Es necesario agregar un nombre")
  @NotBlank(message = "El nombre no puede estar en blanco")
  private String nombre;

  @NotNull(message = "Es necesario agregar un apellido")
  @NotBlank(message = "El apellido no puede estar en blanco")
  private String apellido;

  @NotNull(message = "Es necesario agregar un correo")
  @NotBlank(message = "El correo no puede estar en blanco")
  @Email(message = "El correo electrónico no es válido")
  private String correo;

  @NotNull(message = "Es necesario agregar una contraseña")
  @NotBlank(message = "La contraseña no puede estar en blanco")
  @Size(min = 7, message = "La contraseña debe tener al menos 7 caracteres")
  private String contraseña;

  private LocalDate fechaDeCreacion;
  private List<String> cursos;
}
