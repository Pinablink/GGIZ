package br.com.ggiz.ggizWeb.util;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGResponseMessage 
	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7307797203778366516L;
	private Integer statusCode;
	private String  message;
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "GResponseMessageDTO [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
}
