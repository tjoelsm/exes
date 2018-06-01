package com.app.exes.service.services;

import com.app.exes.entities.dao.SegPersonas;

public interface SegPersonasService {
    SegPersonas findPersonById(int numeroPersona);
    int addNewUser(SegPersonas persona);
}
