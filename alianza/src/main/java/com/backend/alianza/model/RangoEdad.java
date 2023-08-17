package com.backend.alianza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RangoEdad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRangoEdad;

    private int limInferior;

    private int limSuperior;

}
