package br.com.ggiz.ggizWeb.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.ggiz.ggizWeb.api.GGEnvironment;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGTechEnvironment {

	private GGEnvironment genvironment;
	
	public GGTechEnvironment (GGEnvironment genvironment) {
		super();
		this.genvironment = genvironment;
	}
	
	public GGTechEnvironment () {
		super();
	}
	
	public void inform (final String URL) {
		RestTemplate rest = new RestTemplate();
		String strJson = genvironment.formatTechMessage();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity <String> httpEntity = 
				new HttpEntity <String> (strJson, httpHeaders);
		
		String response = 
				rest.postForObject(URL, httpEntity, String.class);
	}
	
	public Object getResource(final String URL) {
		
		RestTemplate rest = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.TEXT_PLAIN);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeaders);
		
		ResponseEntity<String> response = rest.exchange(URL, HttpMethod.GET, entity, String.class);
		
		return response.getBody();
	}
	
}
