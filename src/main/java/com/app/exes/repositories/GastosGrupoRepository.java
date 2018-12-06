package com.app.exes.repositories;
import com.app.exes.entities.PrimaryKeys.GastosGrupoKey;
import com.app.exes.entities.dao.GastosGrupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GastosGrupoRepository extends CrudRepository<GastosGrupo, GastosGrupoKey> {

}
