package br.com.ggiz.ggizWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.ggiz.ggizWeb.domain.dto.GUsuarioRequestLoginDTO;
import br.com.ggiz.ggizWeb.domain.dto.GUsuarioResponseLoginDTO;
import br.com.ggiz.ggizWeb.exception.GGizWebNotFoundUser;
import br.com.ggiz.ggizWeb.repository.GUsuarioRepository;
import br.com.ggiz.ggizWeb.repository.entity.GUsuario;
import br.com.ggiz.ggizWeb.service.contract.GService;
import br.com.ggiz.ggizWeb.util.GGizWebProperties;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GLoginService 
 			implements GService {
	
	@Autowired
	private GUsuarioRepository repository;
	
	
	@Override
	public Object execute (Object obReturn)  {
		
		GUsuarioRequestLoginDTO glogin = (GUsuarioRequestLoginDTO)obReturn;
		
		String strName = glogin.getUsuarioLogin();
		GUsuario gUsuario = repository.findByNome(strName);
		GUsuarioResponseLoginDTO gUsuarioDTO = new GUsuarioResponseLoginDTO();
		//Assert.notNull(gUsuario, "Obj Null");
		if (gUsuario == null) { throw new GGizWebNotFoundUser();}
		/*GUsuarioResponseLoginDTO gUsuarioDTO = new GUsuarioResponseLoginDTO();
		gUsuarioDTO.setId(new Long(10));
		gUsuarioDTO.setIdTpUsuario(new Long(2));
		gUsuarioDTO.setSenha(glogin.getSenha());
		gUsuarioDTO.setUsuario("Weber Alves dos Santos");*/
		
		return gUsuarioDTO;
	}
	
}
