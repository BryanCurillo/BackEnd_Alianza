package com.backend.alianza.controller;

import com.backend.alianza.model.Anexo;
import com.backend.alianza.service.AnexoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexo")
@CrossOrigin(origins = {"*"})
public class AnexoController {

    @Autowired
    AnexoServiceImpl anexoService;

    @GetMapping("/get")
    public ResponseEntity<List<Anexo>> list() {
        return new ResponseEntity<>(anexoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Anexo> create(@RequestBody Anexo a) {
        return new ResponseEntity<>(anexoService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Anexo> update(@PathVariable Long id, @RequestBody Anexo a) {
        Anexo anexo = anexoService.findById(id);
        if (anexo != null) {
            try {
                anexo.setDocumentoAnexo(a.getDocumentoAnexo());
                anexo.setTipoDocumentoAnexo(a.getTipoDocumentoAnexo());
                anexo.setFichaPersonal(a.getFichaPersonal());

                return new ResponseEntity<>(anexoService.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Anexo> delete(@PathVariable Long id) {
        anexoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
