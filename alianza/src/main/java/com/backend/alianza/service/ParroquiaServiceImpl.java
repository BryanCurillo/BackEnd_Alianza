package com.backend.alianza.service;

import com.backend.alianza.model.Parroquia;
import com.backend.alianza.repository.ParroquiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;

@Service
public class ParroquiaServiceImpl  extends GenericServiceImpl<Parroquia, Long> implements GenericService<Parroquia, Long> {

    @Autowired
    private ParroquiaRepository repository;
    @Override
    public CrudRepository<Parroquia, Long> getDao() {
        return repository;
    }
}
