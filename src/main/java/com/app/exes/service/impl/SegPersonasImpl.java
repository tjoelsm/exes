package com.app.exes.service.impl;

import com.app.exes.entities.dao.SegPersonas;
import com.app.exes.repositories.SegPersonasRepository;
import com.app.exes.service.services.SegPersonasService;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Service;


@Service
public class SegPersonasImpl implements SegPersonasService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SegPersonasImpl.class);

    @Autowired
    private SegPersonasRepository personasRepository;

    @Override
    public SegPersonas findPersonById(int numeroPersona) {
        return personasRepository.findByClave_CodPersona(numeroPersona);
    }

    @Override
    public int addNewUser(SegPersonas persona) {
        SegPersonas result = null;
        try {
           // validar que el email no existe.
            if(personasRepository.findByEmail(persona.getEmail())==null) {
                result = personasRepository.save(persona);
            } else{
                return 409;
            }
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
