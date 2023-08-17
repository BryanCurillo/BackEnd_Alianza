package com.backend.alianza.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TipoAnexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoAnexo")
    private int idTipoAnexo;

    @Column(name = "nombreTipo")
    private String nombreTipo;

}
