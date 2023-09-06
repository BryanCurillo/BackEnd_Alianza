package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

//    @ManyToOne
//    @JoinColumn(name = "idFichaInscripcion")
//    private FichaInscripcion fichaInscripcion;

    @OneToOne(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaDesvinculacion> fichaDesvinculacions;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Anexo> anexos;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaSalud> fichaSaluds;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaRepresentante>fichaRepresentantes;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaEducativa>fichaEducativas;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaFamiliar>fichaFamiliars;

    @OneToMany(mappedBy = "fichaPersonal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaInscripcion>fichaInscripcions;
}
