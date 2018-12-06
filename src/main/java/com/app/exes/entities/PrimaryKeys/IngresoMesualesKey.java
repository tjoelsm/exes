package com.app.exes.entities.PrimaryKeys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Data
public class IngresoMesualesKey implements Serializable {

    private static final long serialVersionUID=7;

    @Column(name = "TAP05_COD_INGRESO")
    private String codIngreso;
}