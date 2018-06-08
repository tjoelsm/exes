package com.app.exes.entities.PrimaryKeys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Data
public class MesesKey implements Serializable {

    private static final long serialVersionUID=2;

    @Column(name = "TIA02_COD_MES")
    private String codMes;
}
