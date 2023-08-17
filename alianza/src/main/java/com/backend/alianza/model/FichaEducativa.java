package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaEducativa")
public class FichaEducativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaEducativa")
    private Long idFichaEducativa;

    @Column(name = "centroEducativo")
    private String centroEducativo;

    @Column(name = "direccionEducativa")
    private String direccionEducativa;

    @Column(name = "referenciaEducativa")
    private String referenciaEducativa;

    @Column(name = "jornadaEducativa")
    private String jornadaEducativa;

    @Column(name = "observacionesEducativa")
    private String observacionesEducativa;

    @Column(name = "gradoEducativo")
    private String gradoEducativo;
}
