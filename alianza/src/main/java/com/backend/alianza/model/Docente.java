package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "docente")
public class Docente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDocente;

    private String apellidosDocente;

    private String nombresDocente;

    private String ciIdentidadDocente;

    private String tituloDocente;

    private String materiaDocente;

    @OneToOne(mappedBy = "docente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List <Curso> cursos;




}
