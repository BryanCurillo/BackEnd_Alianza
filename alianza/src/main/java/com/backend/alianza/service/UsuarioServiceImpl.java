package com.backend.alianza.service;


import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Usuario;
import com.backend.alianza.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Override
	public CrudRepository<Usuario, Long> getDao() {
		return repository;
	}

	@Override
	public Usuario search(String username) {
		return  repository.findByUsername(username);
	}
}