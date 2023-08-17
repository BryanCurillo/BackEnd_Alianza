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
@Table(name="rangoEdad")
public class RangoEdad  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRangoEdad;

    private int limInferior;

    private int limSuperior;

    @JsonIgnore
    @OneToMany(mappedBy = "idRangoEdad")
    private List<FichaPersonal> listFichaPersonal;

}
