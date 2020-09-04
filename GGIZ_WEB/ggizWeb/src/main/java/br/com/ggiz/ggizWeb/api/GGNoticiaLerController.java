package br.com.ggiz.ggizWeb.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ggiz.ggizWeb.domain.dto.GGNoticiaResponseLerDTO;
import br.com.ggiz.ggizWeb.exception.GGizUnknownTokenException;
import br.com.ggiz.ggizWeb.filter.GGizApiFilter;
import br.com.ggiz.ggizWeb.service.GGTokenValidate;
import br.com.ggiz.ggizWeb.service.contract.GGService;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ggiz/api/v1/noticia")
public class GGNoticiaLerController {
	
	@Autowired
	@Qualifier("GGNoticiaLerService")
	private GGService service;
	
	@Autowired
	private GGTokenValidate serviceToken;
	
	@GetMapping("/ler/{id}")
	public ResponseEntity<Object> getNewRead (@RequestHeader Map<String, String> headers,
			@RequestAttribute(GGizApiFilter.STR_TOKEN_UNKNOWN_ATTR) boolean tokenOk, @PathVariable("id") Long id) {
		
		if (tokenOk) {
			this.serviceToken.validToken(headers);
			GGNoticiaResponseLerDTO ggreponse = (GGNoticiaResponseLerDTO)this.service.executeFind(id);
			return ResponseEntity.ok(ggreponse);
		} else {
			throw new GGizUnknownTokenException();
		}
	}

}
