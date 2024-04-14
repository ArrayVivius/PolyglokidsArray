package com.polyglokids.com.persistence.models.course;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.polyglokids.com.persistence.models.lesson.LessonModel;
import com.polyglokids.com.persistence.models.user.UserModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

  @Column(name = "numero_de_clase")
  private Integer numero_de_clase;

  @ManyToMany(mappedBy = "courses")
  private List<UserModel> alumnos;

  @JsonManagedReference
  @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<LessonModel> lecciones;

}
