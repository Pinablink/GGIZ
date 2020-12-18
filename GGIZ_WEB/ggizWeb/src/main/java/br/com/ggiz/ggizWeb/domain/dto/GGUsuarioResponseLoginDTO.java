package br.com.ggiz.ggizWeb.domain.dto;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGUsuarioResponseLoginDTO 
    implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7186671745444688870L;
	private Long     id;
	private String usuario;
	private String   senha;
	private Long   idTpUsuario;
    
	public GGUsuarioResponseLoginDTO () {
		super ();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdTpUsuario() {
		return idTpUsuario;
	}

	public void setIdTpUsuario(Long idTpUsuario) {
		this.idTpUsuario = idTpUsuario;
	}

	@Override
	public String toString() {
		return "GUsuarioDTO [id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", idTpUsuario=" + idTpUsuario
				+ "]";
	}
	
	
}