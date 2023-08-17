package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProvincia;

    private String provinciaNombre;

    @JsonIgnore
    @OneToMany(mappedBy = "idProvincia")
    private List<Canton> listCantones;
}
