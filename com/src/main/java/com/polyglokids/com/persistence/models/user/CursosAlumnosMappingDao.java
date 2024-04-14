package com.polyglokids.com.persistence.models.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosAlumnosMappingDao extends JpaRepository<CursosAlumnosMappingModel, Long> {
  // Otros métodos aquí...
  @Query("SELECT m.user FROM CursosAlumnosMappingModel m WHERE m.curso.id = :cursoId")
  List<UserModel> findUsersByCursoId(@Param("cursoId") String cursoId);
}
