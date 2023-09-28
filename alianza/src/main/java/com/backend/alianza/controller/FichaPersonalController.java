package com.backend.alianza.controller;

import com.backend.alianza.model.FichaInscripcion;
import com.backend.alianza.model.FichaPersonal;
import com.backend.alianza.service.FichaFamiliarServiceImpl;
import com.backend.alianza.service.FichaPersonalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fichaPersonal")
public class FichaPersonalController {

    @Autowired
    public FichaPersonalServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<List<FichaPersonal>> list() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/busquedaRE/{ci}/{gen}/{rang}/{est}")
    public ResponseEntity<List<FichaPersonal>> busquedaRE(@PathVariable String ci, @PathVariable String gen,
            @PathVariable int rang, @PathVariable boolean est) {
        if (ci.equalsIgnoreCase("NA")) {
            ci = "";
        }
        if (gen.equalsIgnoreCase("NA")) {
            gen = "";
        }
        return new ResponseEntity<>(service.busquedaRE(ci, gen, rang, est), HttpStatus.OK);
    }

    @GetMapping("/busqueda/{ci}/{gen}/{est}")
    public ResponseEntity<List<FichaPersonal>> busqueda(@PathVariable String ci, @PathVariable String gen,
            @PathVariable boolean est) {
        if (ci.equalsIgnoreCase("NA")) {
            ci = "";
        }
        if (gen.equalsIgnoreCase("NA")) {
            gen = "";

        }
        return new ResponseEntity<>(service.busqueda(ci, gen, est), HttpStatus.OK);
    }

    @GetMapping("/busquedaCiNombre/{est}/{busqueda}")
    public ResponseEntity<List<Map<String, Object>>> busquedaCiNombre(@PathVariable boolean est,
            @PathVariable String busqueda) {
        busqueda = busqueda.trim();
        if (busqueda.equalsIgnoreCase("NA")) {
            busqueda = "";
        }

        List<Object[]> resultados = service.busquedaCiNombre(est, busqueda);
        List<Map<String, Object>> resultadosConNombres = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> resultadoMap = new HashMap<>();
            resultadoMap.put("idFichaPersonal", fila[0]);
            resultadoMap.put("apellidos", fila[1]);
            resultadoMap.put("nombres", fila[2]);
            resultadoMap.put("ciIdentidad", fila[3]);
            resultadoMap.put("estVinculacion", fila[4]);
            resultadoMap.put("foto", fila[5]);
            resultadosConNombres.add(resultadoMap);
        }

        return new ResponseEntity<>(resultadosConNombres, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<FichaPersonal> create(@RequestBody FichaPersonal fp) {
        return new ResponseEntity<>(service.save(fp), HttpStatus.CREATED);
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
                fichaPersonal.setEstVinculacion(fp.isEstVinculacion());
                fichaPersonal.setFechaRegistro(fp.getFechaRegistro());

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
