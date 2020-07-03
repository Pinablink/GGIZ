package br.com.ggiz.ggizWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.ggiz.ggizWeb.domain.dto.GGUsuarioRequestLoginDTO;
import br.com.ggiz.ggizWeb.domain.dto.GGUsuarioResponseLoginDTO;
import br.com.ggiz.ggizWeb.exception.GGizWebNotFoundUser;
import br.com.ggiz.ggizWeb.repository.GGUsuarioRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gusuario;
import br.com.ggiz.ggizWeb.service.contract.GGService;
import br.com.ggiz.ggizWeb.util.GGizWebProperties;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGLoginService 
 			implements GGService {
	
	@Autowired
	private GGUsuarioRepository repository;
	
	
	@Override
	public Object execute (Object obReturn)  {
		
		GGUsuarioRequestLoginDTO glogin = (GGUsuarioRequestLoginDTO)obReturn;
		
		String strName = glogin.getUsuarioLogin();
		Gusuario gUsuario = repository.findByNome(strName);
		GGUsuarioResponseLoginDTO gUsuarioDTO = new GGUsuarioResponseLoginDTO();
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
