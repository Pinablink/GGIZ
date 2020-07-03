package br.com.ggiz.ggizWeb.service;





import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggiz.ggizWeb.domain.dto.GGUsuarioRequestCreateDTO;
import br.com.ggiz.ggizWeb.exception.GGizCadUserException;
import br.com.ggiz.ggizWeb.repository.GGTpUsuarioRepository;
import br.com.ggiz.ggizWeb.repository.GGUsuarioRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gtpusuario;
import br.com.ggiz.ggizWeb.repository.entity.Gusuario;
import br.com.ggiz.ggizWeb.service.contract.GGService;

/**
 * 
 *  @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGPreCadService 
	implements GGService{

	@Autowired
	private GGTpUsuarioRepository tpUsuarioRepository;
	
	@Autowired
	private GGUsuarioRepository gUsuarioRepository;
	
	@Override
	public Object execute(Object obReturn) {
		
		GGUsuarioRequestCreateDTO ob = 
				(GGUsuarioRequestCreateDTO)obReturn;
		
		Long idTpUsuario = this.getDefaultTpUser();
		
		Gusuario gUsuario = new Gusuario();
		gUsuario.setId_gtpusuario(idTpUsuario);
		gUsuario.setNome(ob.getUsuario());
		gUsuario.setEmail(ob.getEmail());
		gUsuario.setSenha(ob.getSenha());
		gUsuario.setDtcriacao(new Date(System.currentTimeMillis()));
		Gusuario ver = this.gUsuarioRepository.findByNomeAndEmail(gUsuario.getNome(), gUsuario.getEmail());
		
		gUsuario = this.gUsuarioRepository.save(gUsuario);
		
		return this.validResponseInput(gUsuario);
	}
	
	private Gusuario validResponseInput (Gusuario usuario) {
		Long idRet = usuario.getId();
		
		if (idRet != null && idRet.longValue() > 0)
			return usuario;
		
		throw new GGizCadUserException();
	}
	
	private Long getDefaultTpUser () {

		Gtpusuario gtpUsuario = this.tpUsuarioRepository.findByDescricao("usuario");
		
		if (gtpUsuario == null) {
			throw new GGizCadUserException();
		} 
		
		return gtpUsuario.getId();
	}
	
	

}
