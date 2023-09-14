package com.backend.alianza.repository;

import com.backend.alianza.model.FichaPersonal;
import com.backend.alianza.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaPersonalRepository  extends JpaRepository<FichaPersonal, Long> {

    FichaPersonal findByCiIdentidad(String ciIdentidad);

}
