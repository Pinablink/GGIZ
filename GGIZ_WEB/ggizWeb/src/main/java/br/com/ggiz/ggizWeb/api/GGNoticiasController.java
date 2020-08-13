package br.com.ggiz.ggizWeb.api;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ggiz.ggizWeb.domain.dto.GGNoticiaResponseDTO;
import br.com.ggiz.ggizWeb.exception.GGizUnknownTokenException;
import br.com.ggiz.ggizWeb.filter.GGizApiFilter;
import br.com.ggiz.ggizWeb.service.contract.GGService;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@CrossOrigin(origins = "*") // Retirar no código oficial
@RequestMapping("/ggiz/api/v1/noticias")
public class GGNoticiasController {

	@Autowired
	@Qualifier("GGNoticiasService")
	private GGService service;
	
	@GetMapping
	public ResponseEntity<Object> getNews (@RequestHeader Map<String, String> headers/*,
			@RequestAttribute(GGizApiFilter.STR_TOKEN_UNKNOWN_ATTR) boolean tokenOk*/) {
		
		//if (tokenOk) {
			List<GGNoticiaResponseDTO> listRet = 
					(List<GGNoticiaResponseDTO>)service.executeFindAll();
			return new ResponseEntity<Object>(listRet, HttpStatus.OK);
		//} else {
		//	throw new GGizUnknownTokenException();
		//}
	}
	
	
}
