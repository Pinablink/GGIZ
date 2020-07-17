package br.com.ggiz.ggizWeb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ggiz.ggizWeb.domain.dto.GGNoticiaResponseLerDTO;
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
	
	@GetMapping("/ler/{id}")
	public ResponseEntity<Object> getNewRead (@PathVariable("id") Long id) {
		GGNoticiaResponseLerDTO ggreponse = (GGNoticiaResponseLerDTO)this.service.executeFind(id);
		return ResponseEntity.ok(ggreponse);
	}

}
