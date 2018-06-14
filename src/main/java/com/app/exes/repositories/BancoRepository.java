package com.app.exes.repositories;

import com.app.exes.entities.PrimaryKeys.BancoKey;
import com.app.exes.entities.dao.Banco;
import org.springframework.data.repository.CrudRepository;

public interface BancoRepository extends CrudRepository<Banco, BancoKey>  {
}
