package com.backend.alianza.repository;

import com.backend.alianza.model.FichaSalud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaSaludRepository extends JpaRepository<FichaSalud,Long> {
}
