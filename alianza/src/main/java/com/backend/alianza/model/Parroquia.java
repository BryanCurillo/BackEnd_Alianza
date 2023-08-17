package com.backend.alianza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="parroquia")
public class Parroquia implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idParroquia;

    private String parroquiaNombre;

    @ManyToOne
    @JoinColumn(name = "idCanton", referencedColumnName = "idCanton")
    private Canton idCanton;


    @JsonIgnore
    @OneToMany(mappedBy = "idParroquia")
    private List<FichaPersonal> listFichaPersonal;
}
