package com.polyglokids.com.domain.entities;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.polyglokids.com.domain.entities.types.course.CourseDTO;
import com.polyglokids.com.domain.entities.types.course.CourseProps;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * CourseEntity
 */

@Getter
@Setter
@Component
@NoArgsConstructor
@ToString
public class CourseEntity {
  private String id;
  private CourseProps courseProps;

  private CourseEntity(UUID id, CourseProps props) {
    this.id = id.toString();
    this.courseProps = props;
  }

  public static CourseEntity create(CourseDTO createProps) {
    CourseProps courseProps = CourseProps.builder()
        .nombre(createProps.getNombre())
        .descripcion(createProps.getDescripcion())
        .profesor(createProps.getProfesor())
        .idioma(createProps.getIdioma())
        .numero_de_clase(createProps.getNumeroDeClase())
        .build();

    UUID uuid = UUID.randomUUID();
    CourseEntity courseEntity = new CourseEntity(uuid, courseProps);
    return courseEntity;
  }
}
