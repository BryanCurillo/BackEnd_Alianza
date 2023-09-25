package com.backend.alianza.repository;

import com.backend.alianza.model.FichaInscripcion;
import com.backend.alianza.model.FichaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichaInscripcionRepository extends JpaRepository<FichaInscripcion, Long> {
    @Query(value = "SELECT * " +
            " FROM public.ficha_inscripcion f " +
            " WHERE f.id_ficha_personal = :id ", nativeQuery = true)
    List<FichaInscripcion> busquedaID(@Param("id") Long id);

    @Query(value = "Select f.*\n" +
            "from ficha_inscripcion f\n" +
            "where f.id_curso = ?;", nativeQuery = true)
    List<FichaInscripcion> listaEstudiantes(@Param("idCurso") Long idCurso);
}
