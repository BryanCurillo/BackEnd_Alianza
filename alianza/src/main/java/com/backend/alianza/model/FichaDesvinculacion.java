package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaDesvinculacion")
public class FichaDesvinculacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaDesvinculacion")
    private int idFichaDesvinculacion;

    @Column(name = "fechaDesvinculacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaDesvinculacion;

    @Column(name = "motivoDesvinculacion")
    private String motivo;

    @Column(name = "anexosExtrasDesvinculacion", columnDefinition = "LONGTEXT")
    private String anexosExtras;
}
