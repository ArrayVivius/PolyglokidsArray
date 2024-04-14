package com.polyglokids.com.domain.entities.types.homework;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * HomeWorkProps
 */
@Builder
@Getter
@Setter
public class HomeWorkProps {

  String id;
  String nombre;
  LocalDate fecha;
  String ubicacion;
  String leccion;
}
