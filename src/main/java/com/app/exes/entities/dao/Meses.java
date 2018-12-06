package com.app.exes.entities.dao;

import com.app.exes.entities.PrimaryKeys.MesesKey;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TIA_SEG_MESES")
@Data
public class Meses {

    @EmbeddedId
    private MesesKey clave;

    @Column(name = "TIA02_DESC_MES")
    private String mes;

}
