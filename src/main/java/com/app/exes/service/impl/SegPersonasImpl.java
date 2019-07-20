package com.app.exes.service.impl;

import com.app.exes.entities.dao.SegPersonas;
import com.app.exes.repositories.SegPersonasRepository;
import com.app.exes.service.SegPersonasService;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Component
public class SegPersonasImpl implements SegPersonasService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SegPersonasImpl.class);
    private static final Integer ITERATION_COUNT = 10;

    @Autowired
    private SegPersonasRepository personasRepository;

    @Override
    public SegPersonas findPersonById(int numeroPersona) {
        return personasRepository.findByClave_CodPersona(numeroPersona);
    }

    @Override
    public SegPersonas findPersonByEmail(String email) {
            return personasRepository.findByClave_Email(email);
    }

    @Override
    public int addNewUser(SegPersonas persona) {
        SegPersonas result = null;
        try {
           // validar que el email no existe.
            if(personasRepository.findByClave_Email(persona.getClave().getEmail())==null) {
                String pss = persona.getPass();
                persona.setPass(getEncode(pss));
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

    @Override
    public boolean autenticateUser(String username, String password) {

        SegPersonas result = null;
        try {
            result = personasRepository.findByClave_EmailAndPass(username, getEncode(password));
            if (result!=null){
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


        return false;
    }

    public synchronized String getEncode(String password)
            throws NoSuchAlgorithmException, IOException {
        String saltChars = "tiago123";
        String encodedPassword = null;
        byte[] salt = base64ToByte(saltChars);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(salt);

        byte[] btPass = digest.digest(password.getBytes("UTF-8"));
        for (int i = 0; i < ITERATION_COUNT; i++) {
            digest.reset();
            btPass = digest.digest(btPass);
        }

        encodedPassword = byteToBase64(btPass);
        return encodedPassword;
    }

    private byte[] base64ToByte(String str) throws IOException {

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] returnbyteArray = decoder.decodeBuffer(str);

        return returnbyteArray;
    }

    private String byteToBase64(byte[] bt) {

        BASE64Encoder endecoder = new BASE64Encoder();
        String returnString = endecoder.encode(bt);

        return returnString;
    }

}
