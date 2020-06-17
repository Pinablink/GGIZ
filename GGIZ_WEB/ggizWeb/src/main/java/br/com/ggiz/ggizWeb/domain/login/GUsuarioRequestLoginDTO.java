package br.com.ggiz.ggizWeb.domain.login;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GUsuarioRequestLoginDTO 
		implements Serializable {

	private String usuarioLogin;
	private String senhaLogin;
	
	public GUsuarioRequestLoginDTO () {
		super ();
	}

	public String getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public String getSenhaLogin() {
		return senhaLogin;
	}

	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}

	@Override
	public String toString() {
		return "GUsuarioRequestLoginDTO [usuarioLogin=" + usuarioLogin + ", senhaLogin=" + senhaLogin + "]";
	}
	
}
