package br.com.ggiz.ggizWeb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ggiz.ggizWeb.domain.dto.GUsuarioRequestLoginDTO;
import br.com.ggiz.ggizWeb.domain.dto.GUsuarioResponseLoginDTO;
import br.com.ggiz.ggizWeb.service.contract.GService;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@RequestMapping("/api/v1/login")
public class GLoginValidController {

	@Autowired
	private GService loginService;
	
	@PostMapping
	public ResponseEntity loginValid (@RequestBody GUsuarioRequestLoginDTO usLogin) {
		
		GUsuarioResponseLoginDTO obRet = (GUsuarioResponseLoginDTO)this.loginService.execute(usLogin);
		
		return ResponseEntity.ok(obRet);
	}
}
