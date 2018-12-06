package com.app.exes.entities.dao;

import com.app.exes.entities.PrimaryKeys.IngresoMesualesKey;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TIA_APP_INGRESOSMES")
@Data
public class IngresoMesuales {

    @EmbeddedId
    private IngresoMesualesKey clave;

    @Column(name = "TAP05_COD_TIPOINGRESO")
    private String tipoIngreso;

    @Column(name = "TAP05_MES")
    private String mes;

    @Column(name = "TAP05_IMP")
    private Double importe;

    @Column(name = "TAP05_OBSERVACIONES")
    private String notas;
}
