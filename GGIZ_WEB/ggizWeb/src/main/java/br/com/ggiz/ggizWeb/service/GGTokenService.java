package br.com.ggiz.ggizWeb.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ggiz.ggizWeb.domain.dto.GGTokenRequestDTO;
import br.com.ggiz.ggizWeb.repository.GGUsersysenvRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gusersysenv;
import br.com.ggiz.ggizWeb.service.contract.GGService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 *  @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGTokenService 
	implements GGService{

	private static final Long _30MINEXP = 1800000l;
	
	@Autowired
	private GGUsersysenvRepository repository;
	
	@Override
	public Object executeFind(Object ob) {
		GGTokenRequestDTO tokenDto = (GGTokenRequestDTO)ob;
		
		
		Gusersysenv gtUserSysEnv =  
				repository.findByUsersys(tokenDto.getUser());
		
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

}
