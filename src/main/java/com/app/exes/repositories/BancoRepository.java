package com.app.exes.repositories;

import com.app.exes.entities.PrimaryKeys.BancoKey;
import com.app.exes.entities.dao.Banco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BancoRepository extends CrudRepository<Banco, BancoKey>  {
    
}
