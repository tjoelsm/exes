package com.app.exes.entities.dao;

import com.app.exes.entities.PrimaryKeys.BancoKey;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TIA_APP_ENTIDAD")
@Data
public class Banco {

    @EmbeddedId
    private BancoKey clave;

    @Column(name = "TAP06_NOMBRE")
    private String nombre;

    @Column(name = "TAP06_WEB")
    private String web;

}
