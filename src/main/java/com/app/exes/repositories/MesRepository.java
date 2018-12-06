package com.app.exes.repositories;

import com.app.exes.entities.PrimaryKeys.MesesKey;
import com.app.exes.entities.dao.Meses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MesRepository extends CrudRepository<Meses, MesesKey> {

    Meses findByMes(String mes);

}
