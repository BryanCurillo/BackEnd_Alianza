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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaPersonal")
public class FichaPersonal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFichaPersonal;

    private String foto;

    private String apellidos;

    private String nombres;

    private String ciIdentidad;

    private String nacionalidad;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaNacimiento;

    private String genero;

    private String zona;

    private String barrioSector;

    private String direccion;

    private String referencia;

    private double coordenadaX;

    private double coordenadaY;

    @ManyToOne
    @JoinColumn(name = "idRangoEdad", referencedColumnName = "idRangoEdad")
    private RangoEdad rangoEdad;

    @ManyToOne
    @JoinColumn(name = "idEtnia", referencedColumnName = "idEtnia")
    private Etnia etnia;

    @ManyToOne
    @JoinColumn(name = "idParroquia", referencedColumnName = "idParroquia")
    private Parroquia parroquia;

    @ManyToOne
    @JoinColumn(name = "idFichaInscripcion")
    private FichaInscripcion fichaInscripcion;


}
