package com.backend.alianza.controller;

import com.backend.alianza.model.Usuario;
import com.backend.alianza.repository.UsuarioRepository;
import com.backend.alianza.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService UsuarioService;
    @Autowired
    UsuarioRepository UserRepository;



    @PostMapping("/signin")
    public Usuario IniciarSesion(@RequestBody Usuario usuario) throws Exception {
        if (UserRepository.existsByUsername(usuario.getUsername())) {
            if (UserRepository.existsByPassword(usuario.getPassword())) {
                return UsuarioService.search(usuario.getUsername());
            } else {
                throw new Exception("Error: Datos Erroneos!");
            }
        } else {
            throw new Exception("Error: Datos Erroneos!");
        }
    }


    @GetMapping("/read")
    public ResponseEntity<List<Usuario>> getUsuariosList() {
        try {
            return new ResponseEntity<>(UsuarioService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{usuarioId}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario obj) {
        Usuario fndobj = UsuarioService.findById(id);
        if (fndobj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndobj.setUsername(obj.getUsername());
                fndobj.setPassword(obj.getPassword());
                return new ResponseEntity<>(UsuarioService.save(fndobj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/delete/{usuarioId}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Usuario usuario = UsuarioService.findById(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                UsuarioService.delete(id);
                return new ResponseEntity<>(UsuarioService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @GetMapping("/search/{username}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return UsuarioService.findById(id);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) throws Exception {
        // VERIFICAR SI HAY EXISTENCIA DE USUARIO EN NUESTRA BD..
        if (!UserRepository.existsByUsername(usuario.getUsername())) {
            return UserRepository.save(usuario);
        } else {
            throw new Exception("Error: Usuario ya esta en la BD!");
        }
    }








}
