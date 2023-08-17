package com.backend.alianza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class FichaDesvinculacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFichaDesvinculacion;

    private Date fechaDesvinculacion;

    private String motivo;

    private String anexosExtras; //PERDIR EXPLICACION aa
}
