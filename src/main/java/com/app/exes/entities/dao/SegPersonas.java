package com.app.exes.entities.dao;

import com.app.exes.entities.PrimaryKeys.SegPersonaKey;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name="TIA_SEG_PERSONAS")
@Data
public class SegPersonas {

    @EmbeddedId
    private SegPersonaKey clave;

    @Column(name = "TIA01_NOMBRE")
    private String nombrePersona;

    @Column(name = "TIA01_APELLIDOS")
    private String apellidosPersona;

    @Column(name = "TIA01_ULTIMO_ACCESS")
    private Date ultimoAcceso;

    @Column(name = "TIA01_LOGIN_PASS")
    private String pass;



}
