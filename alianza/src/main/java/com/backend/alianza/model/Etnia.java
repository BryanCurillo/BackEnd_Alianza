package com.backend.alianza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Etnia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtnia;

    private String etniaNombre;
}
