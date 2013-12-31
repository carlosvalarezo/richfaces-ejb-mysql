package com.demo.faces.EJB.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Usuarios database table.
 * 
 */
@Entity
@Table(name="Usuarios")
@NamedQuery(name="Usuarios.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idUsuarios;

	private int cantonUsuarios;

	private String loginUsuarios;

	private String passwordUsuarios;

	public Usuario() {
	}

	@Id
	public int getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public int getCantonUsuarios() {
		return this.cantonUsuarios;
	}

	public void setCantonUsuarios(int cantonUsuarios) {
		this.cantonUsuarios = cantonUsuarios;
	}

	public String getLoginUsuarios() {
		return this.loginUsuarios;
	}

	public void setLoginUsuarios(String loginUsuarios) {
		this.loginUsuarios = loginUsuarios;
	}

	public String getPasswordUsuarios() {
		return this.passwordUsuarios;
	}

	public void setPasswordUsuarios(String passwordUsuarios) {
		this.passwordUsuarios = passwordUsuarios;
	}

}