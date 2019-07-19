package com.app.exes.service.impl;

import com.app.exes.entities.dao.GastosMensuales;
import com.app.exes.repositories.GastosMensualesRepository;
import com.app.exes.service.GastosMensualesService;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Service;

@Service
public class GastosMensualesImpl implements GastosMensualesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GastosMensualesImpl.class);
    @Autowired
    GastosMensualesRepository gastosMensualesRepository;

    @Override
    public int addNewBill(GastosMensuales nuevoGasto) {
        GastosMensuales result = null;
        try {
            result = gastosMensualesRepository.save(nuevoGasto);
        }catch (TransientDataAccessException e){
            LOGGER.error("##### ERROR TransientDataAccessException ####" + e.getMessage());
            return 500;
        }catch (NonTransientDataAccessException e){
            LOGGER.error("##### ERROR NonTransientDataAccessException ####" + e.getMessage());
            return 500;
        }catch (ScriptException e){
            LOGGER.error("##### ERROR ScriptException ####" + e.getMessage());
            return 500;
        }catch (SQLGrammarException e){
            LOGGER.error("##### ERROR SQLGrammarException ####" + e.getMessage());
            return 500;
        }catch (Exception e){
            LOGGER.error("##### ERROR Generic ####" + e.getMessage());
            return 500;
        }
        if(result!=null){
            return 201;
        } else {
            return 404;
        }
    }

}
