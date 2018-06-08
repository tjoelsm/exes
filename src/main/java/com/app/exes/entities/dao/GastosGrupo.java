package com.app.exes.entities.dao;

import com.app.exes.entities.PrimaryKeys.GastosGrupoKey;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TIA_APP_GASTOS_GRUPO")
@Data
public class GastosGrupo {

    @EmbeddedId
    private GastosGrupoKey clave;

    @Column(name = "TAP03_COD_TIPOGASTO")
    private String codTipoGasto;

    @Column(name = "TAP03_NOMBRE_GRUPO")
    private String nombre;
}
