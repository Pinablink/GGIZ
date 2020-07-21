package br.com.ggiz.ggizWeb.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ggiz.ggizWeb.domain.dto.GGReceptorBroadcastResponseDTO;
import br.com.ggiz.ggizWeb.service.contract.GGService;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ggiz/api/v1/broadcast/ctr")
public class GGBroadcastCtrController {

	@Autowired
	@Qualifier("GGBroadcastctrService")
	private GGService service;
	
	@GetMapping("/permissao/{perm}")
	public ResponseEntity<Object> getListReceptorBroadcast (@PathVariable String perm) {
		List<GGReceptorBroadcastResponseDTO> list =  (List<GGReceptorBroadcastResponseDTO>)this.service.executeFind(perm);
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
}
