package com.backend.alianza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="anexo")
public class Anexo  implements Serializable {

    private static final long serialVersionUID=1L;

    private int idAnexo;
    private String documento;
    private String tipoPersonalizado;

    private TipoAnexo idTipoAnexo;

}
