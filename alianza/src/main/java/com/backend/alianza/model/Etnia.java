package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="etnia")
public class Etnia  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtnia;

    private String etniaNombre;

    @OneToOne(mappedBy = "idEtnia")
    private FichaPersonal fichaPersonal;
}
