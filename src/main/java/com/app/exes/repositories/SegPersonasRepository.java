package com.app.exes.repositories;

import com.app.exes.entities.PrimaryKeys.SegPersonaKey;
import com.app.exes.entities.dao.SegPersonas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SegPersonasRepository extends CrudRepository<SegPersonas, SegPersonaKey> {
    SegPersonas findByClave_CodPersona(int codigoPersona);
    SegPersonas findByClave_Email(String email);
}
