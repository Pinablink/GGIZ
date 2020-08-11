package br.com.ggiz.ggizWeb.api;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ggiz.ggizWeb.sys.GGTokenSys;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@RequestMapping("/ggiz/api/v1/token")
public class GGTokenController {
	
	@GetMapping
	public ResponseEntity<Object> getToken (@RequestHeader Map<String, String> headers) {
		final String strToken = headers.get("get_token");
		System.out.println (">>>>>>>>>> " + strToken);
		GGTokenSys ret = new GGTokenSys();
		ret.setToken("adcvfsaAdsfsdfASADSADSAasassacsdsffsdsd");
		return  new ResponseEntity<Object>(ret, HttpStatus.OK);
	}

}
