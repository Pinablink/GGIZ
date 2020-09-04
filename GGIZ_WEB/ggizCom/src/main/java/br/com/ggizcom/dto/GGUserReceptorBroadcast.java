package br.com.ggizcom.dto;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGUserReceptorBroadcast 
	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -809557429226036160L;
	private String nome;
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "GGUserReceptorBroadcast [nome=" + nome + ", email=" + email + "]";
	}
	
	
}
