package br.com.ggiz.ggizWeb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ggiz.ggizWeb.domain.dto.GGUsuarioRequestLoginDTO;
import br.com.ggiz.ggizWeb.domain.dto.GGUsuarioResponseLoginDTO;
import br.com.ggiz.ggizWeb.service.contract.GGService;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@RequestMapping("/api/v1/login")
public class GGLoginValidController {

	@Autowired
	@Qualifier("GGLoginService")
	private GGService gLoginService;
	
	@PostMapping
	public ResponseEntity loginValid (@RequestBody GGUsuarioRequestLoginDTO usLogin) {
		
		GGUsuarioResponseLoginDTO obRet = (GGUsuarioResponseLoginDTO)this.gLoginService.execute(usLogin);
		
		return ResponseEntity.ok(obRet);
	}
}
