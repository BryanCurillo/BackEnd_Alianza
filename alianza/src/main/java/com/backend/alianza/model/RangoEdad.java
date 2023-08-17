package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

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

    @OneToOne(mappedBy = "idRangoEdad")
    private FichaPersonal fichaPersonal;

}
