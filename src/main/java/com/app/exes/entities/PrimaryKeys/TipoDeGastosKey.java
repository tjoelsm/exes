package com.app.exes.entities.PrimaryKeys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Data
public class TipoDeGastosKey implements Serializable {

    private static final long serialVersionUID=3;

    @Column(name = "TAP01_COD_TIPOGASTO")
    private String tipoGasto;
}

