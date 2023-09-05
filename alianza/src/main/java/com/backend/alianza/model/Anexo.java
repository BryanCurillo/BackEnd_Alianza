package com.backend.alianza.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anexo")
public class Anexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAnexo")
    private int idAnexo;

    @Column(name = "documentoAnexo", columnDefinition = "TEXT")
    private String documentoAnexo;

    @Column(name = "tipoDocumentoAnexo")
    private String tipoDocumentoAnexo;


    @ManyToOne
    @JoinColumn(name = "idFichaInscripcion")
    private FichaInscripcion fichaInscripcion;

}
