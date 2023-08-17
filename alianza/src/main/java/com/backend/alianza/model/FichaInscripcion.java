package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaInstruccion")
public class FichaInscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaInscripcion")
    private Long idFichaInscripcion;

    @Column(name = "fechaIngresoInscrip")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaIngresoInscrip;

    @Column(name = "fechaEgresoInscrip")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaEgreso;

    @Column(name = "proyectoInscrip")
    private String proyectoInscrip;

    @Column(name = "situacionIngresoInscrip")
    private String situacionIngresoInscrip;

    @Column(name = "asistenciaInscrip")
    private String asistenciaInscrip;

    @Column(name = "jornadaAsistenciaInscrip")
    private String jornadaAsistenciaInscrip;
}
