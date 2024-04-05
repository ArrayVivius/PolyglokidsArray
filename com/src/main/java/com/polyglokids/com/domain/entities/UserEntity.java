package com.polyglokids.com.domain.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.hibernate.mapping.List;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.polyglokids.com.domain.entities.types.user.UserDTO;
import com.polyglokids.com.domain.entities.types.user.UserProps;
import com.polyglokids.com.persistence.models.role.ERoleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * user
 */
@Getter
@Setter
@Component
@NoArgsConstructor
@ToString
public class UserEntity {
  private String id;
  private UserProps userProps;

  private UserEntity(UUID id, UserProps props) {
    this.id = id.toString();
    this.userProps = props;
  }

  public static UserEntity create(UserDTO createProps) {
    UserProps userProps = UserProps.builder()
        .nombre(createProps.getNombre())
        .apellido(createProps.getApellido())
        .correo(createProps.getCorreo())
        .contraseña(createProps.getContraseña())
        .fecha_de_creacion(createProps.getFechaDeCreacion())
        .roles(Arrays.asList(ERoleType.USUARIO))
        .build();
    UUID uuid = UUID.randomUUID();
    UserEntity userEntity = new UserEntity(uuid, userProps);
    System.out.println(userEntity.toString());
    return userEntity;
  }
}
