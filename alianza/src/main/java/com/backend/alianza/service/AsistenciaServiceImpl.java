package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Asistencia;
import com.backend.alianza.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaServiceImpl extends GenericServiceImpl<Asistencia,Long>implements GenericService<Asistencia,Long> {

    @Autowired
    AsistenciaRepository asistenciaRepository;

    @Override
    public CrudRepository<Asistencia, Long> getDao() {
        return asistenciaRepository;
    }
}
