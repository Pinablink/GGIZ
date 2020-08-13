package br.com.ggiz.ggizWeb.filter;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
//@Component
public class GGizApiFilter implements Filter {

	private static final String  STR_GET_TOKEN_ATTR = "GET_TOKEN";
	private static final String  STR_TOKEN_ATTR = "token";
	public  static final String  STR_TOKEN_UNKNOWN_ATTR = "TOKEN_UNKNOWN";
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest srequest = (HttpServletRequest) request;
		HttpServletResponse response = (HttpServletResponse) resp;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	    response.setHeader("Access-Control-Expose-Headers", "Location");
	    
	    if (this.isGetToken(srequest)) {
	    	boolean ret = this.scanRequestToken(srequest);
		    request.setAttribute(GGizApiFilter.STR_TOKEN_UNKNOWN_ATTR, ret);
	    } 
	    
	    chain.doFilter(request, response);
	    	
	}
	
	private boolean isGetToken (HttpServletRequest srequest) {
		final String strGetToken = srequest.getHeader(GGizApiFilter.STR_GET_TOKEN_ATTR);
		return (strGetToken != null 
				&& strGetToken.trim().length() > 0);
	}
	
	private boolean scanRequestToken (HttpServletRequest srequest) {
		Enumeration<String> enuHeadersName = srequest.getHeaderNames();
		boolean tokenKeyExist = false;
		
		if (enuHeadersName != null) {
			while (enuHeadersName.hasMoreElements()) {
				final String strkeytoken = enuHeadersName.nextElement();
				
				if (strkeytoken.equals(GGizApiFilter.STR_TOKEN_ATTR)) {
					
					
					if (strkeytoken != null 
							&& strkeytoken.trim().length() > 0) {
						
						String strcontent = srequest.getHeader(strkeytoken);
						
						if (strcontent != null 
								&& strcontent.trim().length() > 0) {
							tokenKeyExist = true;
							//Ainda necessário implementar o procedimento de validação
						}
						
					}
				}
				
			}
		}
		
		return tokenKeyExist;
	}

}
