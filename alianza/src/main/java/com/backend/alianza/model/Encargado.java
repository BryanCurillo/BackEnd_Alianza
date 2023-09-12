package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "encargado")
public class Encargado implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEncargado;

    private String apellidosEncargado;

    private String nombresEncargado;

    private String ciIdentidadEncargado;

    @OneToOne(mappedBy = "encargado", cascade = CascadeType.ALL)
    @JsonIgnore
    private Usuario usuario;

}
