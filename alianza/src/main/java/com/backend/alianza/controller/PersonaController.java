package com.backend.alianza.controller;

import com.backend.alianza.model.Persona;
import com.backend.alianza.repository.PersonaRepository;
import com.backend.alianza.repository.UsuarioRepository;
import com.backend.alianza.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    public PersonaServiceImpl personaService;

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/get")
    public ResponseEntity<List<Persona>> list() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/exists-identificacion/{dni}")
    public ResponseEntity<Boolean> checkIfDNIExists(@PathVariable String dni) {
        boolean exists = personaRepository.existsByCiPasaporte(dni);
        return ResponseEntity.ok(exists);
    }

//    @PostMapping("/post")
//    public ResponseEntity<Persona> create(@RequestBody Persona pe) {
//
//        return new ResponseEntity<>(personaService.save(pe), HttpStatus.CREATED);
//    }

    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody Persona pe) {
        if (!personaRepository.existsByCiPasaporte(pe.getCiPasaporte())) {
            return new ResponseEntity<>(personaService.save(pe), HttpStatus.CREATED);
        }else{
            return ResponseEntity.badRequest().body("IDENTIFICACION_REPETIDA");
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona pe) {
        Persona persona = personaService.findById(id);
        if (persona != null) {
            try {
                persona.setApellidosPersona(pe.getApellidosPersona());
                persona.setNombresPersona(pe.getNombresPersona());
                persona.setCiPasaporte(pe.getCiPasaporte());
                persona.setTipoIdentificacion((pe.getTipoIdentificacion()));


                return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
