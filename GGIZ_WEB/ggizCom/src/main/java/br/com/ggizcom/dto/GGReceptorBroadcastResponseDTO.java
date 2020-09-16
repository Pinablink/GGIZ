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
	private Long id;
	private List<GGUserReceptorBroadcastDTO> listUserDest;
	private String message;
	
	public List<GGUserReceptorBroadcastDTO> getListUserDest() {
		return listUserDest;
	}
	public void setListUserDest(List<GGUserReceptorBroadcastDTO> listUserDest) {
		this.listUserDest = listUserDest;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "GGReceptorBroadcastResponseDTO [id=" + id + ", listUserDest=" + listUserDest + ", message=" + message
				+ "]";
	}
	
	
}
