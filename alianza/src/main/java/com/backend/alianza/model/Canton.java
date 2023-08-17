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
@Table(name="canton")
public class Canton  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCanton;

    private String cantonNombre;

    @ManyToOne
    @JoinColumn(name = "idProvincia", referencedColumnName = "idProvincia")
    private Provincia idProvincia;

    @JsonIgnore
    @OneToMany(mappedBy = "idCanton")
    private List<Canton> listParroquias;
}
