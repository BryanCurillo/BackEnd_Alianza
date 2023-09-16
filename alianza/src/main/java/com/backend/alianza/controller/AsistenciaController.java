package com.backend.alianza.controller;


import com.backend.alianza.model.Asistencia;
import com.backend.alianza.service.AsistenciaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {

    @Autowired
    public AsistenciaServiceImpl asistenciaService;

    @GetMapping("/get")
    public ResponseEntity<List<Asistencia>> list() {
        return new ResponseEntity<>(asistenciaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Asistencia> create(@RequestBody Asistencia c) {
        return new ResponseEntity<>(asistenciaService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Asistencia> update(@PathVariable Long id, @RequestBody Asistencia c) {
        Asistencia asistencia = asistenciaService.findById(id);
        if (asistencia != null) {
            try {
                asistencia.setFechaAsistencia(c.getFechaAsistencia());
                asistencia.setEstadoAsistencia(c.getEstadoAsistencia());
                asistencia.setObservacionesAsistencia(c.getObservacionesAsistencia());
                asistencia.setCurso(c.getCurso());
                asistencia.setFichaInscripcion(c.getFichaInscripcion());

                return new ResponseEntity<>(asistenciaService.save(asistencia), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Asistencia> delete(@PathVariable Long id) {
        asistenciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

