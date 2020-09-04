package br.com.ggizcom.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGReceptorBroadcastResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5901817013705839155L;
	private List<GGUserReceptorBroadcast> listUserDest;
	private String message;
	
	public List<GGUserReceptorBroadcast> getListUserDest() {
		return listUserDest;
	}
	public void setListUserDest(List<GGUserReceptorBroadcast> listUserDest) {
		this.listUserDest = listUserDest;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "GGReceptorBroadcastResponseDTO [listUserDest=" + listUserDest + ", message=" + message + "]";
	}
}
