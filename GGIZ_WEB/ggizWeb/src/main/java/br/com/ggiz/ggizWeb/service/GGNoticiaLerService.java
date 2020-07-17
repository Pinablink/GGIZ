package br.com.ggiz.ggizWeb.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ggiz.ggizWeb.domain.dto.GGNoticiaResponseLerDTO;
import br.com.ggiz.ggizWeb.exception.GGizNewsLerNotFoundException;
import br.com.ggiz.ggizWeb.repository.GGNoticiaLerRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gnoticialer;
import br.com.ggiz.ggizWeb.service.contract.GGService;

/**
 * 
 *  @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGNoticiaLerService 
		implements GGService {

	@Autowired
	private GGNoticiaLerRepository repository;
	
	@Override
	public Object executeFind(Object ob) {
		Optional<Gnoticialer> gNoticiaLer =  this.repository.findById((Long)ob);
		return this.formatRet(gNoticiaLer);
	}
	
	@Override
	public Object executeFindAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private GGNoticiaResponseLerDTO formatRet (Optional<Gnoticialer>  optional) {
		Gnoticialer noticia = optional.get();
		GGNoticiaResponseLerDTO response;
		
		if (noticia != null) {
			String strTexto = noticia.getTexto();
			
			if (strTexto != null && strTexto.trim().length() > 0) {
				response = new GGNoticiaResponseLerDTO();
				response.setTexto(strTexto);
				return response;
			}

		} 
		
		throw new GGizNewsLerNotFoundException();
	}

}
