package br.com.ggiz.ggizWeb.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.ggiz.ggizWeb.exception.GGizExpiredTokenException;
import br.com.ggiz.ggizWeb.exception.GGizInvalidTokenException;
import br.com.ggiz.ggizWeb.filter.GGizApiFilter;
import br.com.ggiz.ggizWeb.util.GGTechEnvironment;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;


/**
 * 
 *  @author Weber Alves dos Santos (Pinablink)
 *
 */
@Service
public class GGTokenValidate {
	
	@Autowired
	private Environment env;

	//Video no youtube 01:08:39
	public void validToken (Map<String, String> headers) {
		final String tokenReceive = headers.get(GGizApiFilter.STR_TOKEN_ATTR);
		String keySeed = (String)(new GGTechEnvironment().getResource(env.getProperty("LOCATE_GET_SEED_KEY")));
		this.validStrToken(tokenReceive, keySeed);
	}
	
	private void validStrToken (final String strToken, final String keySeed) {
		
		try {
			
			Claims claims = Jwts.parser()
					.setSigningKey(keySeed)
					.parseClaimsJws(strToken)
					.getBody();
			
			//final boolean EXPIRED = (claims.getExpiration().before(new Date(System.currentTimeMillis())));
			
			//if (EXPIRED) {
			//	throw new GGizExpiredTokenException();
			//}
		} catch (ExpiredJwtException timeException) {
			throw new GGizExpiredTokenException();
		} catch (SignatureException ex) {
			throw new GGizInvalidTokenException();
		} 
		
	}
	
	
}
