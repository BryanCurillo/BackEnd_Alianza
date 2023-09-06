package com.backend.alianza.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaSalud")
public class FichaSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaSalud")
    private int idFichaSalud;

    @Column(name = "condicionesMedicas")
    private String condicionesMedicas;

    @Column(name = "pesoFichaSalud")
    private double pesoFichaSalud;

    @Column(name = "tallaFichaSalud")
    private double tallaFichaSalud;

    @Column(name = "discapacidadNNAFichaSalud")
    private Boolean discapacidadNNAFichaSalud;

    @Column(name = "tipoDiscapacidadFichaSalud")
    private String tipoDiscapacidadFichaSalud;

    @Column(name = "porcentajeDiscapacidadFichaSalud")
    private double porcentajeDiscapacidadFichaSalud;

    @Column(name = "enfermedadesPrevalentesFichaSalud")
    private  String enfermedadesPrevalentesFichaSalud;

    @ManyToOne
    @JoinColumn(name = "idFichaPersonal")
    private FichaPersonal fichaPersonal;

}
