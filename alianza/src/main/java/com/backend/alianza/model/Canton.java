package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Canton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCanton;

    private String cantonNombre;

    @ManyToOne
    @JoinColumn(name = "idProvincia", referencedColumnName = "idProvincia")
    private Provincia idProvincia;

    @JsonIgnore
    @OneToMany(mappedBy = "idCanton")
    private List<Canton> listParroquias;
}
