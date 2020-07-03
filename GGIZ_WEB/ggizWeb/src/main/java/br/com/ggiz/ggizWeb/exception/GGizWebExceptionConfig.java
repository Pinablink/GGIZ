package br.com.ggiz.ggizWeb.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ggiz.ggizWeb.util.GGizWebProperties;
import br.com.ggiz.ggizWeb.util.GGResponseMessage;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@RestControllerAdvice
public class GGizWebExceptionConfig 
		extends ResponseEntityExceptionHandler {
	
	@Autowired
	private GGizWebProperties gProperties; 
	
	 @ExceptionHandler({
		 GGizWebNotFoundUser.class
	 })
	public ResponseEntity<GGResponseMessage> ggizDataNotFound () {
		 GGResponseMessage gResponseMessage = new GGResponseMessage();
		 gResponseMessage.setMessage(gProperties.getMessage().getUserNotFound());
		 gResponseMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(gResponseMessage);
	}
	 
	 
	 @ExceptionHandler({
		 GGizCadUserException.class
	 })
	public ResponseEntity<GGResponseMessage> ggizCadUserError () {
		 GGResponseMessage gResponseMessage = new GGResponseMessage();
		 gResponseMessage.setMessage(gProperties.getMessage().getErrCadUser());
		 gResponseMessage.setStatusCode(HttpStatus.LOCKED.value());
		 return ResponseEntity.status(HttpStatus.LOCKED).body(gResponseMessage);
	}

}
