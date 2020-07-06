package br.com.ggiz.ggizWeb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GGizWebNotFoundUser extends RuntimeException{
}