package com.app.exes.entities.PrimaryKeys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Data
public class IngresoKey implements Serializable {

    private static final long serialVersionUID=6;

    @Column(name = "TAP04_COD_TIPOINGRESO")
    private String codTipoIngreso;
}