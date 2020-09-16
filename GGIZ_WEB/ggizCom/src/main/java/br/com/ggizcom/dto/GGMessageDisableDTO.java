package br.com.ggizcom.dto;

import java.io.Serializable;


/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGMessageDisableDTO 
	implements Serializable {

	private String id;
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "GGMessageDisableDTO [id=" + id + ", status=" + status + "]";
	}

	
	
}
