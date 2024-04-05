package com.polyglokids.com.usecases.types;

import com.polyglokids.com.domain.entities.types.user.UserDTO;
import com.polyglokids.com.persistence.models.user.UserModel;

/**
 * ICreateUser
 */
public interface ICreateUser {

  UserModel save(UserDTO Prop);
}
