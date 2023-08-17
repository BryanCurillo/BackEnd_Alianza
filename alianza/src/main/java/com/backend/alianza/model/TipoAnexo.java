package com.backend.alianza.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tipoAnexo")
public class TipoAnexo  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoAnexo")
    private long idTipoAnexo;

    @Column(name = "nombreTipo")
    private String nombreTipo;

}
