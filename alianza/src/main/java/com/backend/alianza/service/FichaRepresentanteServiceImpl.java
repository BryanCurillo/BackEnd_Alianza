package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.FichaRepresentante;
import com.backend.alianza.repository.FichaRepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FichaRepresentanteServiceImpl extends GenericServiceImpl<FichaRepresentante,Long> implements GenericService<FichaRepresentante,Long> {
    @Autowired
    FichaRepresentanteRepository fichaRepresentanteRepository;
    @Override
    public CrudRepository<FichaRepresentante, Long> getDao() {
        return fichaRepresentanteRepository;
    }
}
