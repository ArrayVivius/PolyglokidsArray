package com.polyglokids.com.persistence.models.lesson;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.polyglokids.com.persistence.models.course.CourseModel;
import com.polyglokids.com.persistence.models.homework.HomeWorkModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leccion")
public class LessonModel {
  @Id
  @Column(name = "leccion_id")
  private String id; // Corregir el tipo de dato del ID

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "fecha")
  private LocalDate fecha;

  @Column(name = "numero_de_leccion")
  private Integer numero_de_leccion;

  @Column(name = "tema")
  private String tema;

  @Column(name = "nota")
  private String nota;

  @Column(name = "link_de_clase")
  private String link;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "curso_id")
  private CourseModel curso;

  @JsonManagedReference
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "leccion")
  private HomeWorkModel tarea;
}
