package com.polyglokids.com.persistence.models.user;

import com.polyglokids.com.persistence.models.course.CourseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * CursosAlumnosMappingModels
 */

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso_alumnos")
public class CursosAlumnosMappingModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id_user")
  private UserModel user;

  @ManyToOne
  @JoinColumn(name = "curso_id", referencedColumnName = "curso_id")
  private CourseModel curso;

}
