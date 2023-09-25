package com.backend.alianza.repository;

import com.backend.alianza.model.Curso;
import com.backend.alianza.model.FichaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    @Query(value = "Select c.* from curso c where c.id_docente = ?;", nativeQuery = true)
    List<Curso> listaCurso(@Param("id_docente") Long id_docente);

}
