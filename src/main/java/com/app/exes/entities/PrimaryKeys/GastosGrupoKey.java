package com.app.exes.entities.PrimaryKeys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Data
public class GastosGrupoKey implements Serializable {

    private static final long serialVersionUID=5;

    @Column(name = "TAP03_COD_GRUPO")
    private String codGrupo;

    @Column(name = "TAP03_COD_TIPOGASTO")
    private String tipoGasto;

}