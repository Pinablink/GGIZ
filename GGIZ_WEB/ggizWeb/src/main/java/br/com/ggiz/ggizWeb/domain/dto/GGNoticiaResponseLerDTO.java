package br.com.ggiz.ggizWeb.domain.dto;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGNoticiaResponseLerDTO 
	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5336840482084074128L;
	private String texto;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		return "GGNoticiaResponseLerDTO [texto=" + texto + "]";
	}
	
}
