package com.backend.alianza.controller;

import com.backend.alianza.model.FichaInscripcion;
import com.backend.alianza.model.FichaPersonal;
import com.backend.alianza.service.FichaFamiliarServiceImpl;
import com.backend.alianza.service.FichaPersonalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoPersonal")
public class FichaPersonalController {

    @Autowired
    public FichaPersonalServiceImpl service;


    @GetMapping("/get")
    public ResponseEntity<List<FichaPersonal>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<FichaPersonal> create(@RequestBody FichaPersonal fp) {
        return new ResponseEntity<>(service.save(fp), HttpStatus.CREATED);
    }

    @GetMapping("/search/{cedula}")
    public FichaPersonal obtenerPersona(@PathVariable String cedula) {
        return service.search(cedula);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<FichaPersonal> update(@PathVariable Long id, @RequestBody FichaPersonal fp) {
        FichaPersonal fichaPersonal = service.findById(id);
        if (fichaPersonal != null) {
            try {
                fichaPersonal.setFoto(fp.getFoto());
                fichaPersonal.setApellidos(fp.getApellidos());
                fichaPersonal.setNombres(fp.getNombres());
                fichaPersonal.setCiIdentidad(fp.getCiIdentidad());
                fichaPersonal.setNacionalidad(fp.getNacionalidad());
                fichaPersonal.setFechaNacimiento(fp.getFechaNacimiento());
                fichaPersonal.setGenero(fp.getGenero());
                fichaPersonal.setZona(fp.getZona());
                fichaPersonal.setBarrioSector(fp.getBarrioSector());
                fichaPersonal.setDireccion(fp.getDireccion());
                fichaPersonal.setReferencia(fp.getReferencia());
                fichaPersonal.setCoordenadaX(fp.getCoordenadaX());
                fichaPersonal.setCoordenadaY(fp.getCoordenadaY());
                fichaPersonal.setRangoEdad(fp.getRangoEdad());
                fichaPersonal.setEtnia(fp.getEtnia());
                fichaPersonal.setParroquia(fp.getParroquia());

                return new ResponseEntity<>(service.save(fichaPersonal), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FichaPersonal> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
