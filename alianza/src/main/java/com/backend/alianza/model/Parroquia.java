package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Parroquia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParroquia;

    private String parroquiaNombre;

    @ManyToOne
    @JoinColumn(name = "idCanton", referencedColumnName = "idCanton")
    private Canton idCanton;
}
