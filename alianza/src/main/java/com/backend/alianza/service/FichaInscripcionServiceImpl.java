package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.FichaInscripcion;
import com.backend.alianza.repository.FichaInscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FichaInscripcionServiceImpl extends GenericServiceImpl<FichaInscripcion,Long>implements GenericService<FichaInscripcion,Long> {
    @Autowired
    FichaInscripcionRepository fichaInscripcionRepository;
    @Override
    public CrudRepository<FichaInscripcion, Long> getDao() {
        return fichaInscripcionRepository;
    }
}
