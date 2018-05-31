package com.app.exes.service.impl;

import com.app.exes.entities.dao.SegPersonas;
import com.app.exes.repositories.SegPersonasRepository;
import com.app.exes.service.itf.SegPersonasFachada;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Service;


@Service
public class SegPersonasOperaciones implements SegPersonasFachada {

    private static final Logger LOGGER = LoggerFactory.getLogger(SegPersonasOperaciones.class);

    @Autowired
    private SegPersonasRepository personasRepository;

    @Override
    public SegPersonas findPersonById(int numeroPersona) {

        return null;
    }

    @Override
    public int insertPerson(SegPersonas persona) {
        SegPersonas result = null;
        try {
           // if (personasRepository.findByEmail(persona))
            result = personasRepository.save(persona);
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
