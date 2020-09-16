package br.com.ggizcom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ggizcom.dto.GGMessageDisableDTO;
import br.com.ggizcom.service.GGBroadcastctrService;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ggiz/api/v1/message/disable")
public class GGizComDisableMessageController {

	@Autowired
	private GGBroadcastctrService service;
	
	@PostMapping
	public ResponseEntity<Object> disableMessage (@RequestBody GGMessageDisableDTO gMessageDTO) {
		this.service.disableMessage(gMessageDTO);
		gMessageDTO.setStatus("OK");
		return ResponseEntity.ok(gMessageDTO);
	}
}
