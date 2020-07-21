package br.com.ggiz.ggizWeb.domain.dto;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGReceptorBroadcastResponseDTO 
	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5901817013705839155L;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "GGReceptorBroadcastResponseDTO [email=" + email + "]";
	}
	
	

}
