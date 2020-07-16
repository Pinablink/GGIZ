package br.com.ggiz.ggizWeb.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ggiz.ggizWeb.domain.dto.GGNoticiaResponseDTO;
import br.com.ggiz.ggizWeb.service.contract.GGService;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ggiz/api/v1/noticias")
public class GGNoticiasController {

	@Autowired
	@Qualifier("GGNoticiasService")
	private GGService service;
	
	@GetMapping
	public ResponseEntity<Object> getNews () {
		List<GGNoticiaResponseDTO> listRet = 
				(List<GGNoticiaResponseDTO>)service.execute();
		return new ResponseEntity<Object>(listRet, HttpStatus.OK);
	}
}
