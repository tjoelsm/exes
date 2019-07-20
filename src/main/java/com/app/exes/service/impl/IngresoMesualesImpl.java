package com.app.exes.service.impl;

import com.app.exes.entities.dao.IngresoMesuales;
import com.app.exes.repositories.IngresoMesualesRepository;
import com.app.exes.service.IngresoMesualesService;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class IngresoMesualesImpl implements IngresoMesualesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngresoMesualesImpl.class);

    @Autowired
    IngresoMesualesRepository ingresoMesualesRepository;

    @Override
    public int addNewDeposit(IngresoMesuales nuevoIngreso) {
        IngresoMesuales result = null;
        try {
                result = ingresoMesualesRepository.save(nuevoIngreso);
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
