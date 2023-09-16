package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curso")
public class Curso implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCurso;

    private String nombreCurso;

    @Column(name = "fechaInicio")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaInicio;

    @Column(name = "fechaFin")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaFin;

    private Boolean estadoCurso;

    @ManyToOne
    @JoinColumn(name = "idRangoEdad", referencedColumnName = "idRangoEdad")
    private RangoEdad rangoEdad;

    @ManyToOne
    @JoinColumn(name = "idDocente", referencedColumnName = "idDocente")
    private Docente docente;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Asistencia> asistencias;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaInscripcion> fichaInscripcions;




}
