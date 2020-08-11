package br.com.ggiz.ggizWeb.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggiz.ggizWeb.domain.dto.GGNoticiaResponseDTO;
import br.com.ggiz.ggizWeb.exception.GGizNewsNotFoundException;
import br.com.ggiz.ggizWeb.repository.GGNoticiasRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gnoticia;
import br.com.ggiz.ggizWeb.service.contract.GGService;
import br.com.ggiz.ggizWeb.util.GGizDate;

/**
 * 
 *  @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGNoticiasService 
		implements GGService {

	@Autowired
	private GGNoticiasRepository repository;
	
	@Override
	public Object executeFindAll () {
		List<Gnoticia> list =  this.repository.findAll();
		return convert(list);
	}
	
	@Override
	public Object executeFind(Object ob) {
		return null;
	}
	
	private List<GGNoticiaResponseDTO> convert (List<Gnoticia> list) {
		
		Iterator<Gnoticia> iter = list.iterator();
		List<GGNoticiaResponseDTO> listRet = 
				new ArrayList<GGNoticiaResponseDTO>();
		
		Gnoticia gnoticia = null;
		
		while (iter.hasNext()) {
			gnoticia = iter.next();
			GGNoticiaResponseDTO responseDTO =
					new GGNoticiaResponseDTO();
			
			responseDTO.setId(gnoticia.getId());
			responseDTO.setTitulo(gnoticia.getTitulo());
			responseDTO.setDescricao(gnoticia.getDescricao());
			responseDTO.setDtcriacao(GGizDate.getDateFormatStr(gnoticia.getDtcriacao()));
			
			listRet.add(responseDTO);
		}
		
		if (listRet.size() == 0)
			throw new GGizNewsNotFoundException();
		
		return listRet;
	}
}
