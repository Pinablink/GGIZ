package br.com.ggiz.ggizWeb.sys;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGTokenSys 
	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2275806788936900820L;
	
	private String token;
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
