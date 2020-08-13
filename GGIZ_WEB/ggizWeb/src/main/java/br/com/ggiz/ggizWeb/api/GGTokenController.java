package br.com.ggiz.ggizWeb.api;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ggiz.ggizWeb.domain.dto.GGTokenRequestDTO;
import br.com.ggiz.ggizWeb.service.contract.GGService;
import br.com.ggiz.ggizWeb.sys.GGTokenSys;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@RequestMapping("/ggiz/api/v1/token")
public class GGTokenController {
	
	/*
	 * Pesquisa de Criação de Token
	 * Ponto de Criação, video Youtube
	 * 41:45
	 */
	
	@Autowired
	@Qualifier("GGTokenService")
	private GGService service;
	
	@GetMapping
	public ResponseEntity<Object> getToken (@RequestHeader Map<String, String> headers) {
		final String strUserToken = headers.get("get_token");
		GGTokenRequestDTO ggToken = new GGTokenRequestDTO();
		ggToken.setUser(strUserToken);
		ggToken = (GGTokenRequestDTO)service.executeFind(ggToken);
		GGTokenSys ret = new GGTokenSys();
		ret.setToken(ggToken.getToken());
		return  new ResponseEntity<Object>(ret, HttpStatus.OK);
	}

}
