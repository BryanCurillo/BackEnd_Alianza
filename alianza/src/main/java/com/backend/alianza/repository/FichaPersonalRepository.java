package com.backend.alianza.repository;

import com.backend.alianza.model.FichaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichaPersonalRepository extends JpaRepository<FichaPersonal, Long> {

    @Query(value = "SELECT *" +
            "  FROM ficha_personal p  " +
            "  WHERE p.est_vinculacion= :est  " +
            "  AND  p.ci_identidad LIKE CONCAT ('%', :ci, '%')  " +
            "  AND p.genero LIKE CONCAT ('%', :gen, '%')  " +
            "  AND p.id_rango_edad = :rang", nativeQuery = true)
    List<FichaPersonal> busquedaRE(@Param("ci") String ci,
                                   @Param("gen") String gen,
                                   @Param("rang") int rang,
                                   @Param("est") boolean est);


    @Query(value = "SELECT *" +
            "  FROM ficha_personal p  " +
            "  WHERE p.est_vinculacion= :est  " +
            "  AND  p.ci_identidad LIKE CONCAT ('%', :ci, '%')  " +
            "  AND p.genero LIKE CONCAT ('%', :gen, '%')  ", nativeQuery = true)
    List<FichaPersonal> busqueda(@Param("ci") String ci,
                                   @Param("gen") String gen,
                                   @Param("est") boolean est);

}
