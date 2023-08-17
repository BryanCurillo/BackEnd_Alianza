package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CursoGrado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCursoGrado")
    private int idCursoGrado;

    @Column(name = "nombreCursoGrado")
    private String nombreCursoGrado;

}
