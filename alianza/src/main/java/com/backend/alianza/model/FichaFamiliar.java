package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaFamiliar")
public class FichaFamiliar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFichaFamiliar;

    private boolean visitaDomiciliaria;

    private String jefaturaFamiliar;

    private int numIntegrantes;

    private int numAdultos;

    private int numNNA;

    private int numAdultosMayores;

    private String beneficioAdicional;

    private String organizacionBeneficio;

    private boolean discapacidadIntegrantes;

    private String otrasSituaciones;

    @ManyToOne
    @JoinColumn(name = "idTipoFamilia", referencedColumnName = "idTipoFamilia")
    private TipoFamilia idTipoFamilia;

//    private FichaIncripcion id_ficha_inscripcion;
}
