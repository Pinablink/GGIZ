package br.com.ggiz.ggizWeb.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ggiz.ggizWeb.util.GGizError;
import br.com.ggiz.ggizWeb.util.GGizWebProperties;

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
	public ResponseEntity<GGizError> ggizDataNotFound () {
		 GGizError ggizError = new GGizError();
		 ggizError.setMessage(gProperties.getMessage().getUserNotFound());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ggizError);
	}

}
