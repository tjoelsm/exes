package com.app.exes.repositories;
import com.app.exes.entities.PrimaryKeys.IngresoMesualesKey;
import com.app.exes.entities.dao.IngresoMesuales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IngresoMesualesRepository extends CrudRepository<IngresoMesuales, IngresoMesualesKey> {

}
