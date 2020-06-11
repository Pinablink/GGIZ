package br.com.ggiz.ggizWeb.service;

import org.springframework.stereotype.Service;

import br.com.ggiz.ggizWeb.domain.login.GUsuarioResponseLoginDTO;
import br.com.ggiz.ggizWeb.domain.login.GUsuarioRequestLoginDTO;
import br.com.ggiz.ggizWeb.service.contract.GService;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GLoginService 
 			implements GService {
	
	@Override
	public Object execute (Object obReturn) {
		
		GUsuarioRequestLoginDTO glogin = (GUsuarioRequestLoginDTO)obReturn;
		
		GUsuarioResponseLoginDTO gUsuarioDTO = new GUsuarioResponseLoginDTO();
		gUsuarioDTO.setId(new Long(10));
		gUsuarioDTO.setIdTpUsuario(new Long(2));
		gUsuarioDTO.setSenha(glogin.getSenha());
		gUsuarioDTO.setUsuario("Weber Alves dos Santos");
		
		return gUsuarioDTO;
	}
}
