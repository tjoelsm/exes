package com.app.exes.entities.PrimaryKeys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Data
public class BancoKey implements Serializable {
    private static final long serialVersionUID=8;

    @Column(name = "TAP06_COD_ENTIDAD")
    private String codBank;

}
