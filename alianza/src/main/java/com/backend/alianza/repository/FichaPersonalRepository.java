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
            "  AND  p.ci_pasaporte LIKE CONCAT ('%', :ci, '%')  " +
            "  AND p.genero LIKE CONCAT ('%', :gen, '%')  " +
            "  AND p.id_rango_edad = :rang   ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> busquedaRE(@Param("ci") String ci,
                                   @Param("gen") String gen,
                                   @Param("rang") int rang,
                                   @Param("est") boolean est);

    @Query(value = "SELECT COUNT(*) FROM ficha_personal WHERE ci_pasaporte = :ci ", nativeQuery = true)
    int cedulaUnicaFP(@Param("ci") String ci);


    @Query(value = "SELECT * " +
            " FROM ficha_personal where est_vinculacion = :est ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> gelAllByEst(@Param("est") boolean est);

    @Query(value = "SELECT *" +
            "  FROM ficha_personal p  " +
            "  WHERE p.est_vinculacion= :est  " +
            "  AND  p.ci_pasaporte LIKE CONCAT ('%', :ci, '%')  " +
            "  AND p.genero LIKE CONCAT ('%', :gen, '%')  ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> busqueda(@Param("ci") String ci,
                                 @Param("gen") String gen,
                                 @Param("est") boolean est);

    @Query(value = " SELECT p.id_ficha_personal, p.apellidos, p.nombres, p.ci_pasaporte, p.est_vinculacion, p.foto  "
            +
            "             FROM ficha_personal p " +
            "             WHERE p.est_vinculacion = :est" +
            "             AND ( " +
            "               p.ci_pasaporte LIKE (CONCAT('%', :busqueda ,'%')) " +
            "                OR CONCAT(LOWER(p.apellidos), ' ', LOWER(p.nombres)) LIKE LOWER (CONCAT('%', :busqueda ,'%')) "
            +
            "                OR CONCAT(LOWER(p.nombres), ' ', LOWER(p.apellidos)) LIKE LOWER (CONCAT('%', :busqueda ,'%')) "
            +
            "            ) ORDER BY apellidos, nombres", nativeQuery = true)
    List<Object[]> busquedaCiNombre(@Param("est") boolean est,
                                    @Param("busqueda") String busqueda);



    @Query(value = " SELECT *  " +
            "             FROM ficha_personal p " +
            "             WHERE p.est_vinculacion = :est" +
            "             AND ( " +
            "               p.ci_pasaporte LIKE (CONCAT('%', :busqueda ,'%')) " +
            "                OR CONCAT(LOWER(p.apellidos), ' ', LOWER(p.nombres)) LIKE LOWER (CONCAT('%', :busqueda ,'%')) "
            +
            "                OR CONCAT(LOWER(p.nombres), ' ', LOWER(p.apellidos)) LIKE LOWER (CONCAT('%', :busqueda ,'%')) "
            +
            "            ) ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> busquedaFP(@Param("est") boolean est,
                                   @Param("busqueda") String busqueda);


    @Query(value = "SELECT *   " +
            " FROM ficha_personal f   " +
            " WHERE f.id_ficha_personal = :id ORDER BY apellidos, nombres", nativeQuery = true)
    List<FichaPersonal> busquedaID(@Param("id") Long id);

}
