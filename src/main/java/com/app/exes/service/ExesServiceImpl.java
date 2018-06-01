package com.app.exes.service;

import com.app.exes.entities.dao.SegPersonas;
import com.app.exes.repositories.SegPersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExesServiceImpl implements ExesService{

    @Autowired
    SegPersonasRepository repositoryPersonas;

    @Override
    public int addUser(SegPersonas persona) {
        return 200;
    }
}
