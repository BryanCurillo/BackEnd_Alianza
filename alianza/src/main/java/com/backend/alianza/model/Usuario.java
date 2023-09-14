package com.backend.alianza.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;


}
