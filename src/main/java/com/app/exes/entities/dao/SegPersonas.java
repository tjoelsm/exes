package com.app.exes.entities.dao;

import com.app.exes.entities.PrimaryKeys.SegPersonaKey;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name="TIA_SEG_PERSONAS")
@Data
@Getter
@Setter
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

	/**
	 * @return the clave
	 */
	public SegPersonaKey getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(SegPersonaKey clave) {
		this.clave = clave;
	}

	/**
	 * @return the nombrePersona
	 */
	public String getNombrePersona() {
		return nombrePersona;
	}

	/**
	 * @param nombrePersona the nombrePersona to set
	 */
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	/**
	 * @return the apellidosPersona
	 */
	public String getApellidosPersona() {
		return apellidosPersona;
	}

	/**
	 * @param apellidosPersona the apellidosPersona to set
	 */
	public void setApellidosPersona(String apellidosPersona) {
		this.apellidosPersona = apellidosPersona;
	}

	/**
	 * @return the ultimoAcceso
	 */
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	/**
	 * @param ultimoAcceso the ultimoAcceso to set
	 */
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}



}
