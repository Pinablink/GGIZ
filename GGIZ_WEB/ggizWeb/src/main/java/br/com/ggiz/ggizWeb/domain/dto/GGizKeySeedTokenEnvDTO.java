package br.com.ggiz.ggizWeb.domain.dto;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGizKeySeedTokenEnvDTO 
	implements Serializable{

	private String seedKey;
	private String dateInput;
	
	public String getSeedKey() {
		return seedKey;
	}
	
	public void setSeedKey(String seedKey) {
		this.seedKey = seedKey;
	}
	
	public String getDateInput() {
		return dateInput;
	}
	
	public void setDateInput(String dateInput) {
		this.dateInput = dateInput;
	}

	@Override
	public String toString() {
		return "GGizKeySeedTokenEnvDTO [seedKey=" + seedKey + ", dateInput=" + dateInput + "]";
	}
	
	
	
}
