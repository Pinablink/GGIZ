package br.com.ggiz.ggizWeb.api;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.ggiz.ggizWeb.domain.dto.GGUsuarioRequestCreateDTO;
import br.com.ggiz.ggizWeb.repository.entity.Gusuario;
import br.com.ggiz.ggizWeb.service.contract.GGService;
import br.com.ggiz.ggizWeb.util.GGResponseMessage;
import br.com.ggiz.ggizWeb.util.GGTechCadMessage;
import br.com.ggiz.ggizWeb.util.GGTechEnvironment;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping("/ggiz/api/v1/pre/cad")
public class GGPreCadController 
	implements GGController {
	
	@Autowired
	@Qualifier("GGPreCadService")
	private GGService gPreCadService;
	
	private Gusuario ref;
	
	@PostMapping
	public ResponseEntity createUser (@RequestBody GGUsuarioRequestCreateDTO userCreate,
			@RequestHeader Map<String, String> headers) {
		
		String usuraio = userCreate.getUsuario();
		String email = userCreate.getEmail();
		
		if (headers != null) {
			String strHost = headers.get("host");
			CharSequence charSeq = strHost.subSequence(0, 2);
			userCreate.setSenha(this.generatePassword(charSeq));
		}
		
		this.ref = (Gusuario)gPreCadService.execute(userCreate);
		
		GGResponseMessage gRespmsg = new GGResponseMessage();
		gRespmsg.setMessage("SYS-SUCESS");
		gRespmsg.setStatusCode(HttpStatus.OK.value());
		
		
		// NESSE PONTO IRÁ FAZER A CHAMADA PARA O SERVIÇO QUE NOTIFICA O CORE DO SISTEMA DE QUE HOUVE O CADASTRO
		this.informTech();
		// 
		
		return ResponseEntity.ok(gRespmsg);
	}
	
	public String formatTechMessage () {
		Gusuario gusuario 	= this.ref;
		GGTechCadMessage ggTechCadMessage = new GGTechCadMessage();
		ggTechCadMessage.setDatainclusao(gusuario.getDtcriacao().toString());
		ggTechCadMessage.setEmail(gusuario.getEmail());
		Gson 	 gson 		= new Gson();
		return gson.toJson(ggTechCadMessage);
	}
	
	private void informTech () {
		
		try {
			GGPreCadController ref = this;
			new Thread() {
				public void run () {
					//Necessario logar esse ponto
					new GGTechEnvironment(ref).inform();
					//Necessario logar esse ponto
				}
			}.start();
		
		} catch (Exception ex) {
			//Incluir log Sistemico nesse ponto
		}
	}
	
	private String generatePassword (final CharSequence charSeq) {
		long timeMillis = System.currentTimeMillis();
		final int iSeq0 = (int)charSeq.charAt(0);
		final int iSeq1 = (int)charSeq.charAt(1);
		timeMillis = (timeMillis + iSeq0 + iSeq1);
		Random random = new Random(timeMillis);
		long ret = random.nextLong();
		return String.valueOf(ret);
		
	}
}
