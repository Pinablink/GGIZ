package br.com.ggiz.ggizWeb.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import br.com.ggiz.ggizWeb.api.GGEnvironment;
import br.com.ggiz.ggizWeb.domain.dto.GGTokenRequestDTO;
import br.com.ggiz.ggizWeb.domain.dto.GGizKeySeedTokenEnvDTO;
import br.com.ggiz.ggizWeb.repository.GGUsersysenvRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gusersysenv;
import br.com.ggiz.ggizWeb.service.contract.GGService;
import br.com.ggiz.ggizWeb.util.GGTechEnvironment;
import br.com.ggiz.ggizWeb.util.GGizDate;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 *  @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGTokenService 
	implements GGService, GGEnvironment{

	private static final Long _30MINEXP = 1800000l;
	
	@Autowired
	private GGUsersysenvRepository repository;
	
	@Autowired
	private Environment env;
	
	private GGizKeySeedTokenEnvDTO ggizKeySeed; 
	
	@Override
	public Object executeFind(Object ob) {
		GGTokenRequestDTO tokenDto = (GGTokenRequestDTO)ob;
		
		Gusersysenv gtUserSysEnv =  
				repository.findByUsersys(tokenDto.getUser());
		this.ggizKeySeed = new GGizKeySeedTokenEnvDTO();
		this.ggizKeySeed.setSeedKey(gtUserSysEnv.getSeedjwt());
		this.ggizKeySeed.setDateInput(GGizDate.getDateFormatStr(new Date(System.currentTimeMillis())));
		
		this.informEnv();
		tokenDto.setKeySeed(gtUserSysEnv.getSeedjwt());
		tokenDto = this.createToken(tokenDto);
		
		return tokenDto;
	}

	@Override
	public Object executeFindAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private GGTokenRequestDTO createToken(GGTokenRequestDTO tokenDto) {
		
		String tokenRet = Jwts.builder()
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setSubject(tokenDto.getUser())
			.setExpiration(new Date(System.currentTimeMillis() + GGTokenService._30MINEXP))
			.signWith(SignatureAlgorithm.HS256, tokenDto.getKeySeed())
			.compact();
			
		tokenDto.setToken(tokenRet);
		
		return tokenDto;
	}
	
	public String formatTechMessage () {
		Gson 	 gson 		= new Gson();
		return gson.toJson(this.ggizKeySeed);
	}

	private void informEnv () {
		
		try {
			GGTokenService ref = this;
			new Thread() {
				public void run () {
					//Necessario logar esse ponto
					new GGTechEnvironment(ref).inform(env.getProperty("LOCATE_ASSIST_TOKEN"));
					//Necessario logar esse ponto
				}
			}.start();
		
		} catch (Exception ex) {
			//Incluir log Sistemico nesse ponto
		}
	}
}
