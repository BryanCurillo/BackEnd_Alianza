package com.backend.alianza.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Parentesco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParentesco")
    private int idParentesco;

    @Column(name = "parentescoNombre")
    private String parentescoNombre;
}
