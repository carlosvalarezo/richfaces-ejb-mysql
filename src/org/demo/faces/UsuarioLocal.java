package org.demo.faces;

public class UsuarioLocal {
	
	private String loginUsuarios;
	private String cantonUsuarios;
	
	public UsuarioLocal(String loginUsuarios, String cantonUsuarios)
	{
		this.loginUsuarios = loginUsuarios;
		this.cantonUsuarios = cantonUsuarios;
	}
	public String getLoginUsuarios() {
		return loginUsuarios;
	}
	public void setLoginUsuarios(String loginUsuarios) {
		this.loginUsuarios = loginUsuarios;
	}
	public String getCantonUsuarios() {
		return cantonUsuarios;
	}
	public void setCantonUsuarios(String cantonUsuarios) {
		this.cantonUsuarios = cantonUsuarios;
	}

}
