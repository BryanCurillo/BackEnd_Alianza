package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="fichaDesvinculacion")
public class FichaDesvinculacion implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFichaDesvinculacion;

    private Date fechaDesvinculacion;

    private String motivo;

    private String anexosExtras; //PERDIR EXPLICACION aa
}
