package com.app.exes.repositories;

import com.app.exes.entities.PrimaryKeys.SegPersonaKey;
import com.app.exes.entities.dao.SegPersonas;
import org.springframework.data.repository.CrudRepository;

public interface SegPersonasRepository extends CrudRepository<SegPersonas, SegPersonaKey> {

    SegPersonas findByClave_CodPersona(int codigoPersona);
    SegPersonas findByEmail(String email);

}
