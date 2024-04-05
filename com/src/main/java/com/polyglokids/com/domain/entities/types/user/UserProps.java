package com.polyglokids.com.domain.entities.types.user;

import java.time.LocalDate;
import java.util.List;

import com.polyglokids.com.persistence.models.role.ERoleType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserProps {
  String nombre;
  String apellido;
  String correo;
  String contraseña;
  LocalDate fecha_de_creacion;
  List<ERoleType> roles;
  List<String> cursos;
}
