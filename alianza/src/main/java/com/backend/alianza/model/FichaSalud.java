package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class FichaSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaSalud")
    private int idFichaSalud;

    @Column(name = "condicionesMedicas")
    private String condicionesMedicas;

    @Column(name = "peso")
    private double peso;

    @Column(name = "talla")
    private double talla;

    @Column(name = "discapacidadNNA")
    private Boolean discapacidadNNA;

    @Column(name = "tipoDiscapacidad")
    private String tipoDiscapacidad;

    @Column(name = "porcentajeDiscapacidad")
    private double porcentajeDiscapacidad;

    @Column(name = "enfermedadesPrevalentes")
    private  String enfermedadesPrevalentes;

}
