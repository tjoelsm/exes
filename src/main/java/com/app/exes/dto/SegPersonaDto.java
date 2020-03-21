package com.app.exes.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SegPersonaDto {
	
	private int codPersona;
	
	@Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "The E-mail address is not valid. Please verify E-mail introduced")
	private String email;
	
	private String nombrePersona;
	private String apellidosPersona;
    
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date ultimoAcceso;

	/**
	 * @return the codPersona
	 */
	public int getCodPersona() {
		return codPersona;
	}
	/**
	 * @param codPersona the codPersona to set
	 */
	public void setCodPersona(int codPersona) {
		this.codPersona = codPersona;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	
}
