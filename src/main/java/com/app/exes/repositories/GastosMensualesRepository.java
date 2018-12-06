package com.app.exes.repositories;
import com.app.exes.entities.PrimaryKeys.GastosMensualesKey;
import com.app.exes.entities.dao.GastosMensuales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GastosMensualesRepository extends CrudRepository<GastosMensuales, GastosMensualesKey> {

}
