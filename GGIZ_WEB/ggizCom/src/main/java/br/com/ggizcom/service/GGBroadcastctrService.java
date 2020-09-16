package br.com.ggizcom.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggizcom.dto.GGMessageDisableDTO;
import br.com.ggizcom.dto.GGReceptorBroadcastResponseDTO;
import br.com.ggizcom.dto.GGUserReceptorBroadcastDTO;
import br.com.ggizcom.entity.Gbroadcast;
import br.com.ggizcom.entity.Gbroadcastctr;
import br.com.ggizcom.entity.Gusuario;
import br.com.ggizcom.repository.GGBroadcastRespository;
import br.com.ggizcom.repository.GGBroadcastctrRepository;

/**
 * 
 *  @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGBroadcastctrService {

	@Autowired
	private GGBroadcastctrRepository repository;
	private static final String FLAG_STATUS_MESSAGE_SENT = "1";
	
	@Autowired
	private GGBroadcastRespository broadcastRepository;
	private final String recepAut = "1";
	
	public GGReceptorBroadcastResponseDTO executeFind(Object ob) {
		final String permStr = (String)ob;
		
		GGReceptorBroadcastResponseDTO refReturn = new GGReceptorBroadcastResponseDTO();
		Gbroadcast gbroadcast = this.broadcastRepository.findBymsgenvbroad(permStr);
		
		if (gbroadcast != null) {
			List<Gbroadcastctr> listBroadcastCtr =  this.repository.findByEnvbroad(this.recepAut);
			formatResponse(gbroadcast, refReturn, listBroadcastCtr);
		}
		
		return refReturn;
	}
	
	private void formatResponse (Gbroadcast bm, GGReceptorBroadcastResponseDTO gGresponse, 
								List<Gbroadcastctr> list) {
		List<GGUserReceptorBroadcastDTO> listResponse =
				new ArrayList<GGUserReceptorBroadcastDTO>();
		
		Iterator<Gbroadcastctr> iterBroadcast =  list.iterator();
		Gusuario refGUsuario;
		
		while (iterBroadcast.hasNext()) {
			Gbroadcastctr ref = iterBroadcast.next();
			refGUsuario = ref.getGusuario();
			GGUserReceptorBroadcastDTO guser = new GGUserReceptorBroadcastDTO();
			guser.setEmail(refGUsuario.getEmail());
			guser.setNome(refGUsuario.getNome());
			listResponse.add(guser);
		}
		
		gGresponse.setMessage(bm.getMessage());
		gGresponse.setId(bm.getId());
		gGresponse.setListUserDest(listResponse);
		
	}
	
	public void disableMessage (GGMessageDisableDTO refDisable) {
		Long id = Long.valueOf(refDisable.getId());
		Optional<Gbroadcast> optGbroadcast = this.broadcastRepository.findById(id);
		Gbroadcast gbroadcast = optGbroadcast.get();
		gbroadcast.setMsgenvbroad(GGBroadcastctrService.FLAG_STATUS_MESSAGE_SENT);
		this.broadcastRepository.save(gbroadcast);
	}
}
