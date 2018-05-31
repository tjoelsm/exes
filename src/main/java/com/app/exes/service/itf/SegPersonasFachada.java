package com.app.exes.service.itf;

import com.app.exes.entities.dao.SegPersonas;

public interface SegPersonasFachada {
    SegPersonas findPersonById(int numeroPersona);
    int insertPerson(SegPersonas persona);
}
