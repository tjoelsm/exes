package com.app.exes.entities.PrimaryKeys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Data
public class GastosMensualesKey implements Serializable {

    private static final long serialVersionUID=4;

    @Column(name = "TAP02_COD_GASTO")
    private String codigoGasto;

}
