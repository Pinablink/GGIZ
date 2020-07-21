package br.com.ggiz.ggizWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ggiz.ggizWeb.repository.GGBroadcastRespository;
import br.com.ggiz.ggizWeb.service.contract.GGService;

/**
 * 
 *  @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGBroadcastService 
	implements GGService {

	@Autowired
	private GGBroadcastRespository repository;
	
	@Override
	public Object executeFind(Object ob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object executeFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
