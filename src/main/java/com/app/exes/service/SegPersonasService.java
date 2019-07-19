package com.app.exes.service;

import com.app.exes.entities.dao.SegPersonas;

public interface SegPersonasService {
    SegPersonas findPersonById(int numeroPersona);
    SegPersonas findPersonByEmail(String email);
    int addNewUser(SegPersonas persona);
    boolean autenticateUser(String username, String password);
}
