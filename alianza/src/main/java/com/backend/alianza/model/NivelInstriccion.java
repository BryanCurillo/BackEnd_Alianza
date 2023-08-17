package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="nivelInstriccion")
public class NivelInstriccion implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNivelInstruccion")
    private long idNivelInstruccion;

    @Column(name = "nivelInstruccionNombre")
    private String nivelInstruccionNombre;
}
