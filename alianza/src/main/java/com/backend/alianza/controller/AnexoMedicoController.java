package com.backend.alianza.controller;

import com.backend.alianza.model.AnexoMedico;
import com.backend.alianza.service.AnexoMedicoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexoMedico")
@CrossOrigin(origins = {"*"})
public class AnexoMedicoController {

    @Autowired
    AnexoMedicoServiceImpl anexoService;

    @GetMapping("/get")
    public ResponseEntity<List<AnexoMedico>> list() {
        return new ResponseEntity<>(anexoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AnexoMedico> create(@RequestBody AnexoMedico a) {
        return new ResponseEntity<>(anexoService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<AnexoMedico> update(@PathVariable Long id, @RequestBody AnexoMedico a) {
        AnexoMedico anexo = anexoService.findById(id);
        if (anexo != null) {
            try {
                anexo.setDocumentoAnexo(a.getDocumentoAnexo());
                anexo.setFichaSalud(a.getFichaSalud());
                anexo.setTipoAnexo(a.getTipoAnexo());
                anexo.setFechaCarga(a.getFechaCarga());
                anexo.setOtroTipoAnexo(a.getOtroTipoAnexo());
                return new ResponseEntity<>(anexoService.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AnexoMedico> delete(@PathVariable Long id) {
        anexoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
