package com.app.exes.entities.dao;

import com.app.exes.entities.PrimaryKeys.GastosMensualesKey;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TIA_APP_GASTOS")
@Data
public class GastosMensuales {

    @EmbeddedId
    private GastosMensualesKey clave;

    @Column(name = "TAP02_COD_TIPOGASTO")
    private String codTipoGasto;

    @Column(name = "TAP02_MES")
    private String mes;

    @Column(name = "TAP02_IMP_COBRADO")
    private Double importe;

    @Column(name = "TAP02_OBSERVACIOENS")
    private String notas;
}
