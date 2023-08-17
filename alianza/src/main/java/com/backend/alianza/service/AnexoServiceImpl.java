package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.Anexo;
import com.backend.alianza.repository.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AnexoServiceImpl extends GenericServiceImpl<Anexo, Long> implements GenericService<Anexo, Long> {

    @Autowired
    AnexoRepository anexoRepository;

    @Override
    public CrudRepository<Anexo, Long> getDao() {
        return anexoRepository;
    }
}
