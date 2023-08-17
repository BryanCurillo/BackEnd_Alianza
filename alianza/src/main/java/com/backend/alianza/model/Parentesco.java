package com.backend.alianza.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="parentesco")
public class Parentesco implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParentesco")
    private long idParentesco;

    @Column(name = "parentescoNombre")
    private String parentescoNombre;
}
