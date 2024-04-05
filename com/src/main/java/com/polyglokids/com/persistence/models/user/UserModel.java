package com.polyglokids.com.persistence.models.user;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.polyglokids.com.persistence.models.UserCourse.UserCourseModel;
import com.polyglokids.com.persistence.models.role.ERoleType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UserModel implements UserDetails {
  @Id
  @Column(name = "id_user")
  String id;

  @Column(name = "nombre")
  String nombre;

  @Column(name = "apellido")
  String apellido;

  @Column(name = "correo", unique = true)
  String correo;

  @Column(name = "contraseña")
  String contraseña;

  @Column(name = "fecha_de_creacion")
  LocalDate fecha_de_creacion;

  @OneToMany(mappedBy = "usuario")
  Set<UserCourseModel> cursos = new HashSet<>();

  @ElementCollection(targetClass = ERoleType.class)
  @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_user"))
  @Column(name = "role", nullable = false)
  @Enumerated(EnumType.STRING)
  Set<ERoleType> roles;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream()
        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
        .collect(Collectors.toSet());
  }

  @Override
  public String getPassword() {
    return contraseña;
  }

  @Override
  public String getUsername() {
    return correo;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
