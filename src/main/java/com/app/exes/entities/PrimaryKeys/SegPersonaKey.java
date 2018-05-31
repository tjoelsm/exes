package com.app.exes.entities.PrimaryKeys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Data
public class SegPersonaKey implements Serializable {

    private static final long serialVersionUID=1;

    @Id
    @Column(name = "TIA01_COD_PERSONA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codPersona;

}
