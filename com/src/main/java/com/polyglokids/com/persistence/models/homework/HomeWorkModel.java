
package com.polyglokids.com.persistence.models.homework;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.polyglokids.com.persistence.models.lesson.LessonModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * HomeWorkModel
 */

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tarea")
public class HomeWorkModel {

  @Id
  @Column(name = "tarea_id")
  private String id; // Corregir el tipo de dato del ID

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "fecha_de_entrega")
  private LocalDate fecha;

  @Column(name = "ubicacion")
  private String Ubicacion;

  @JsonBackReference
  @OneToOne
  @JoinColumn(name = "leccion_id", nullable = false)
  private LessonModel leccion;
}
