package br.com.ggizcom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ggizcom.dto.GGReceptorBroadcastResponseDTO;
import br.com.ggizcom.service.GGBroadcastctrService;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ggiz/api/v1/message/recepUser")
public class GGizComUserRecepController { 

	@Autowired
	private GGBroadcastctrService service;
	
	@GetMapping("/permissao/{perm}")
	public ResponseEntity<Object> getListReceptorBroadcast (@PathVariable String perm) {
		GGReceptorBroadcastResponseDTO ret = this.service.executeFind(perm);
		return new ResponseEntity<Object>(ret, HttpStatus.OK);
	}
}
