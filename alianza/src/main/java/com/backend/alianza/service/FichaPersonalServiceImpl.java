package com.backend.alianza.service;

import com.backend.alianza.genericService.GenericService;
import com.backend.alianza.genericService.GenericServiceImpl;
import com.backend.alianza.model.FichaPersonal;
import com.backend.alianza.repository.FichaPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaPersonalServiceImpl extends GenericServiceImpl<FichaPersonal, Long> implements GenericService<FichaPersonal, Long> {

    @Autowired
    private FichaPersonalRepository repository;

    @Override
    public CrudRepository<FichaPersonal, Long> getDao() {
        return repository;
    }

    public List<FichaPersonal> busquedaRE(String ci, String gen,int rang, boolean est) {
        return repository.busquedaRE(ci,gen,rang,est);
    }

    public List<FichaPersonal> busqueda(String ci, String gen,boolean est) {
        return repository.busqueda(ci,gen,est);
    }

    public FichaPersonal search(String cedula) {
        return  repository.findByCiIdentidad(cedula);
    }
}
