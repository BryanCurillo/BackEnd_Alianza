package com.backend.alianza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichaRepresentante")
public class FichaRepresentante {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaRepresentante")
    private Long idFichaRepresentante;

    @Column(name = "nombresRepre")
    private String nombresRepre;

    @Column(name = "apellidosRepre")
    private String apellidosRepre;

    @Column(name = "cedulaRepre", unique = true)
    private String cedulaRepre;

    @Column(name = "contactoRepre")
    private String contactoRepre;

    @Column(name = "contactoEmergenciaRepre")
    private String contactoEmergenciaRepre;

    @Column(name = "fechaNacimientoRepre")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaNacimientoRepre;

    @Column(name = "ocupacionPrimariaRepre")
    private String ocupacionPrimariaRepre;

    @Column(name = "ocupacionSecundariaRepre")
    private String ocupacionSecundariaRepre;

    @Column(name = "lugarTrabajoRepre")
    private String lugarTrabajoRepre;

    @Column(name = "observacionesRepre")
    private String observacionesRepre;

    @Column(name = "nivelInstruccionRepre")
    private String nivelInstruccionRepre;

    @Column(name = "parentescoRepre")
    private String parentescoRepre;
}
