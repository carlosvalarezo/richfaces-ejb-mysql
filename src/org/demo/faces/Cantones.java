package org.demo.faces;

import java.io.Serializable;

public class Cantones implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String idCanton;
	private String descripcionCanton;
	
	public Cantones(){}
	
	public Cantones(Cantones canton)
	{
		this.idCanton = canton.idCanton;
		this.descripcionCanton = canton.descripcionCanton;		
	}
	
	public Cantones(String idCanton, String descripcionCanton)
	{
		this.idCanton = idCanton;
		this.descripcionCanton = descripcionCanton;		
	}
	
	public String getIdCanton() {
		return idCanton;
	}
	public void setIdCanton(String idCanton) {
		this.idCanton = idCanton;
	}
	public String getDescripcionCanton() {
		return descripcionCanton;
	}
	public void setDescripcionCanton(String descripcionCanton) {
		this.descripcionCanton = descripcionCanton;
	}
	

}
