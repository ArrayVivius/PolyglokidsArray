package com.polyglokids.com.persistence.models.course;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.polyglokids.com.persistence.models.lesson.LessonModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CourseModel
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class CourseModel {

  @Id
  @Column(name = "curso_id")
  private String id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "descripcion")
  private String descripcion;

  @Column(name = "profesor")
  private String profesor;

  @Column(name = "idioma")
  private String idioma;

  @Column(name = "alumnos")
  private Set<String> alumnos;

  @Column(name = "numero_de_clase")
  private Integer numero_de_clase;
}
