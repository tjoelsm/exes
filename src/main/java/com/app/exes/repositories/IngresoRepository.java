package com.app.exes.repositories;
import com.app.exes.entities.PrimaryKeys.IngresoKey;
import com.app.exes.entities.dao.Ingreso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IngresoRepository extends CrudRepository<Ingreso, IngresoKey> {

}
