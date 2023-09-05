package com.backend.alianza.repository;

import com.backend.alianza.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);

    Boolean existsByUsername(String username);

    Usuario findByusernameAndPassword(String username, String password);

    public boolean existsByPassword(String password);

}
