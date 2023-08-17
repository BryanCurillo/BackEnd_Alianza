package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="fichaSalud")
public class FichaSalud  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaSalud")
    private long idFichaSalud;

    @Column(name = "condicionesMedicas")
    private String condicionesMedicas;

    @Column(name = "peso")
    private double peso;

    @Column(name = "talla")
    private double talla;

    @Column(name = "discapacidadNNA")
    private boolean discapacidadNNA;

    @Column(name = "tipoDiscapacidad")
    private String tipoDiscapacidad;

    @Column(name = "porcentajeDiscapacidad")
    private double porcentajeDiscapacidad;

    @Column(name = "enfermedadesPrevalentes")
    private  String enfermedadesPrevalentes;

}
