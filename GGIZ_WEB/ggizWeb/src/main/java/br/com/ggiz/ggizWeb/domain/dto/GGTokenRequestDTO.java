package br.com.ggiz.ggizWeb.domain.dto;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGTokenRequestDTO 
	implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3642601097621942941L;
	private String user;
	private String keySeed;
	private String token;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getKeySeed() {
		return keySeed;
	}
	
	public void setKeySeed(String keySeed) {
		this.keySeed = keySeed;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "GGTokenRequestDTO [user=" + user + ", keySeed=" + keySeed + ", token=" + token + "]";
	}
	
	
}
