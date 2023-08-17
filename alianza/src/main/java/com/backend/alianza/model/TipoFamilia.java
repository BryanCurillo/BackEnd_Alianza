package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tipoFamilia")
public class TipoFamilia  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTipoFamilia;

    private String nombreTipo;

    @OneToOne(mappedBy = "idTipoFamilia")
    private FichaFamiliar fichaFamiliar;
}
