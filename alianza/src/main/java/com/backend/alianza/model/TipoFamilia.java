package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "idTipoFamilia")
    private List<FichaPersonal> listFichaFamiliar;
}
