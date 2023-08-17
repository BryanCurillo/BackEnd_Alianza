package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class NivelInstriccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNivelInstruccion")
    private int idNivelInstruccion;

    @Column(name = "nivelInstruccionNombre")
    private String nivelInstruccionNombre;
}
