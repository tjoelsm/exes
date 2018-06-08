package com.app.exes.service.impl;

import com.app.exes.entities.dao.Meses;
import com.app.exes.repositories.MesRepository;
import com.app.exes.service.services.MesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MesImpl implements MesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MesImpl.class);

    @Autowired
    MesRepository mesRepository;

    @Override
    public Iterable<Meses> getAllMonths() {
        return mesRepository.findAll();
    }

    @Override
    public Meses getMonthByName(String mes) {
        return mesRepository.findByMes(mes.toUpperCase());
    }
}
