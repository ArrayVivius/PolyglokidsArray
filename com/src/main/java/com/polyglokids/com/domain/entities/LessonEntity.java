package com.polyglokids.com.domain.entities;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.polyglokids.com.domain.entities.types.lesson.LessonDTO;
import com.polyglokids.com.domain.entities.types.lesson.LessonProps;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Component
@NoArgsConstructor
@ToString
public class LessonEntity {
  private String id;
  private Integer nro_lesson;
  private String course_id;
  private LessonProps lessonProps;

  private LessonEntity(UUID id, LessonProps props) {
    this.id = id.toString();
    this.lessonProps = props;
  }

  public static LessonEntity create(LessonDTO createProps) {
    LessonProps lessonProps = LessonProps.builder()
        .nombre(createProps.getNombre())
        .fecha(createProps.getFecha())
        .numero_de_leccion(createProps.getNumero_de_leccion())
        .tema(createProps.getTema())
        .nota(createProps.getNota())
        .link(createProps.getLink())
        .curso(createProps.getCurso())
        .build();
    UUID uuid = UUID.randomUUID();
    LessonEntity lessonEntity = new LessonEntity(uuid, lessonProps);
    return lessonEntity;
  }

}
