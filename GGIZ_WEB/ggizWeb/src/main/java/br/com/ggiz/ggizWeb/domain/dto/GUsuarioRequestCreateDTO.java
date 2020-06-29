package br.com.ggiz.ggizWeb.domain.dto;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GUsuarioRequestCreateDTO 
		implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8471787625895741203L;
	private String usuario;
	private String email;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
