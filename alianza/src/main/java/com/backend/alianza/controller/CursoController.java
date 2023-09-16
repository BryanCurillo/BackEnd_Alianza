package com.backend.alianza.controller;


import com.backend.alianza.model.Curso;
import com.backend.alianza.service.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    public CursoServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<List<Curso>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Curso> create(@RequestBody Curso c) {
        return new ResponseEntity<>(service.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso c) {
        Curso curso = service.findById(id);
        if (curso != null) {
            try {
                curso.setEstadoCurso(c.getEstadoCurso());
                curso.setNombreCurso(c.getNombreCurso());
                curso.setDocente(c.getDocente());
                curso.setFechaInicio(c.getFechaInicio());
                curso.setFechaFin(c.getFechaFin());
                curso.setRangoEdad(c.getRangoEdad());

                return new ResponseEntity<>(service.save(curso), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Curso> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


