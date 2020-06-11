package br.com.ggiz.ggizWeb.domain.login;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GUsuarioRequestLoginDTO 
		implements Serializable {

	private String usuario;
	private String senha;
	
	public GUsuarioRequestLoginDTO () {
		super ();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "GUsuarioDTO [usuario=" + usuario + ", senha=" + senha + "]";
	}
	
	
}
