package br.com.ggiz.ggizWeb.service;





import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggiz.ggizWeb.domain.dto.GGUsuarioRequestCreateDTO;
import br.com.ggiz.ggizWeb.exception.GGizCadMailDupException;
import br.com.ggiz.ggizWeb.exception.GGizCadMailUserDupException;
import br.com.ggiz.ggizWeb.exception.GGizCadUserDupException;
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
		
		this.valideDataCad(gUsuario, 
				this.gUsuarioRepository.findByNomeOrEmail(gUsuario.getNome(), 
				gUsuario.getEmail()));
		
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
	
	private void valideDataCad (Gusuario... gusuario) {
		
		if (gusuario[1] != null) {
			final String strNome = gusuario[0].getNome();
			final String strEmail = gusuario[0].getEmail();
			
			if ((strNome.equals(gusuario[1].getNome()))
					&& (strEmail.equals(gusuario[1].getEmail()))) {
				throw new GGizCadMailUserDupException();
			} else {
				
				if (strNome.equals(gusuario[1].getNome())) {
					throw new GGizCadUserDupException();
				} else if (strEmail.equals(gusuario[1].getEmail())) {
					throw new GGizCadMailDupException();
				}
				
			}
				
		}
	}

}
