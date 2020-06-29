package br.com.ggiz.ggizWeb.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ggiz.ggizWeb.domain.dto.GResponseMessageDTO;
import br.com.ggiz.ggizWeb.domain.dto.GUsuarioRequestCreateDTO;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ggiz/api/v1/pre/cad")
public class GPreCadController {

	@PostMapping
	public ResponseEntity createUser (@RequestBody GUsuarioRequestCreateDTO userCreate) {
		
		String usuraio = userCreate.getUsuario();
		String email = userCreate.getEmail();
		
		GResponseMessageDTO gresponse = new GResponseMessageDTO ();
		gresponse.setMessage("ERR-CAD");
		gresponse.setStatusCode(new Integer(-100));
		
		return ResponseEntity.ok(gresponse);
	}
}
