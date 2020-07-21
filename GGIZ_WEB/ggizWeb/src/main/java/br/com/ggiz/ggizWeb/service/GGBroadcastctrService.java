package br.com.ggiz.ggizWeb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggiz.ggizWeb.domain.dto.GGReceptorBroadcastResponseDTO;
import br.com.ggiz.ggizWeb.exception.GGizBroadcastRecepNotFoundException;
import br.com.ggiz.ggizWeb.repository.GGBroadcastctrRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gbroadcastctr;
import br.com.ggiz.ggizWeb.service.contract.GGService;
import br.com.ggiz.ggizWeb.util.GGizEncodeString;

/**
 * 
 *  @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGBroadcastctrService 
	implements GGService{

	@Autowired
	private GGBroadcastctrRepository repository;
	
	@Override
	public Object executeFind(Object ob) {
		final String permStr = (String)ob;
		List<Gbroadcastctr> listBroadcastCtr =  this.repository.findByEnvbroad(permStr);
		return formatResponse(listBroadcastCtr);
	}

	@Override
	public Object executeFindAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<GGReceptorBroadcastResponseDTO> formatResponse (List<Gbroadcastctr> list) {
		List<GGReceptorBroadcastResponseDTO> listResponse =
				new ArrayList<GGReceptorBroadcastResponseDTO>();
		
		if (list.size() == 0)  throw new GGizBroadcastRecepNotFoundException();
		
		Iterator<Gbroadcastctr> iterBroadcast =  list.iterator();
		
		while (iterBroadcast.hasNext()) {
			Gbroadcastctr ref = iterBroadcast.next();
			GGReceptorBroadcastResponseDTO receptor = new GGReceptorBroadcastResponseDTO();
			receptor.setEmail(GGizEncodeString.encode(ref.getGusuario().getEmail()));
			listResponse.add(receptor);
		}
		
		
		
		return listResponse;
	}

}
