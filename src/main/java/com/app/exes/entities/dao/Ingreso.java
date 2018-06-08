package com.app.exes.entities.dao;

import com.app.exes.entities.PrimaryKeys.IngresoKey;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TIA_APP_INGRESOS")
@Data
public class Ingreso {

    @EmbeddedId
    private IngresoKey clave;

    @Column(name = "TAP04_DEC_INGRESO")
    private String descripcion;

    @Column(name = "TAP04_PRIOCIDAD")
    private int priocidad;

    @Column(name = "TAP04_IMP_PERVISTO")
    private Double importe;
}
