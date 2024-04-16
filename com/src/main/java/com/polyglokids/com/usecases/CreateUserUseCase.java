package com.polyglokids.com.usecases;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.polyglokids.com.domain.entities.UserEntity;
import com.polyglokids.com.domain.entities.types.user.UserDTO;
import com.polyglokids.com.persistence.models.role.ERoleType;
import com.polyglokids.com.persistence.models.user.UserDao;
import com.polyglokids.com.persistence.models.user.UserModel;
import com.polyglokids.com.usecases.types.ICreateUser;

import jakarta.transaction.Transactional;

@Service

@Transactional
public class CreateUserUseCase {

  @Autowired
  private UserDao userDao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserModel save(UserDTO prop) {
    System.err.println("new test");
    try {

      UserEntity userprop = UserEntity.create(prop);
      UserModel userModel = userDao.save(convertEntityToModel(userprop));
      return userModel;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error al tratar de guardar los registros");
    }
  }

  private UserModel convertEntityToModel(UserEntity userEntity) {
    UserModel userModel = new UserModel();
    userModel.setId(userEntity.getId());
    userModel.setNombre(userEntity.getUserProps().getNombre());
    userModel.setApellido(userEntity.getUserProps().getApellido());
    userModel.setCorreo(userEntity.getUserProps().getCorreo());
    userModel.setContraseña(passwordEncoder.encode(userEntity.getUserProps().getContraseña()));
    userModel.setFecha_de_creacion(userEntity.getUserProps().getFecha_de_creacion());
    Set<ERoleType> list = new HashSet<ERoleType>(userEntity.getUserProps().getRoles());
    userModel.setRoles(list);

    // Puedes ajustar la lógica para mapear cursos si es necesario
    // userModel.setCursos(userEntity.getUserProps().getCursos());
    return userModel;
  }
}
