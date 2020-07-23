package br.com.ggiz.ggizWeb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@Component
public class GGizApiFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println (request.getAttribute("X-ORIGN-SYS-CALL"));
		request.removeAttribute("X-ORIGN-SYS-CALL"); 
		HttpServletResponse response = (HttpServletResponse) resp;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	    response.setHeader("Access-Control-Expose-Headers", "Location");
	    chain.doFilter(request, response);
	   
	    response.setHeader("X-Powered-By", "E isso ae");
		int v = 2 + 2;
		
	}

}
