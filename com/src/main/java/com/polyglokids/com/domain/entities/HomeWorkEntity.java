package com.polyglokids.com.domain.entities;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.polyglokids.com.domain.entities.types.homework.HomeWorkDTO;
import com.polyglokids.com.domain.entities.types.homework.HomeWorkProps;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Component
@NoArgsConstructor
@ToString
public class HomeWorkEntity {
  private String id;
  private HomeWorkProps homeworkProps;

  private HomeWorkEntity(UUID id, HomeWorkProps props) {
    this.id = id.toString();
    this.homeworkProps = props;
  }

  public static HomeWorkEntity create(HomeWorkDTO createProps) {
    HomeWorkProps homeworkProps = HomeWorkProps.builder()
        .id(createProps.getId())
        .nombre(createProps.getNombre())
        .fecha(createProps.getFecha())
        .ubicacion("../../../../../../resources/static/documentos/tareas/" + UUID.randomUUID().toString())
        .leccion(createProps.getLeccion())
        .build();
    UUID uuid = UUID.randomUUID();
    HomeWorkEntity homeworkEntity = new HomeWorkEntity(uuid, homeworkProps);
    return homeworkEntity;
  }
}
