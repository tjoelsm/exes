package com.app.exes.entities.dao;

import com.app.exes.entities.PrimaryKeys.TipoDeGastosKey;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="TIA_APP_TIPOGASTO")
@Data
public class TipoDeGastos {

    @EmbeddedId
    private TipoDeGastosKey clave;

    @Column(name = "TAP01_DESC_GASTO")
    private String descGasto;

    @Column(name = "TAP01_PRIOCIDAD")
    private int priocidad;

    @Column(name = "TAP01_FECHA_INICIO")
    private Date fechaInicio;

    @Column(name = "TAP01_FECHA_FIN")
    private Date fechaFin;

    @Column(name = "TAP01_IMP_PERVISTO")
    private Double importe;

}
