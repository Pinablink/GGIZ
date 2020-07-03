package br.com.ggiz.ggizWeb.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import br.com.ggiz.ggizWeb.api.GGController;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGTechEnvironment {

	private GGController gcontroller;
	
	public GGTechEnvironment (GGController gcontroller) {
		super();
		this.gcontroller = gcontroller;
	}
	
	public void inform () {
		String url = "http://localhost:3000/newcadgo";
		RestTemplate rest = new RestTemplate();
		String strJson = gcontroller.formatTechMessage();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity <String> httpEntity = 
				new HttpEntity <String> (strJson, httpHeaders);
		
		String response = 
				rest.postForObject(url, httpEntity, String.class);
	}
	
}
