package br.com.ggiz.monitor.exception;

import br.com.ggiz.monitor.engine.GPoperties;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@SuppressWarnings("serial")
public class GGizException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2124556388831619639L;
	
	public GGizException (String msg) {
		super (msg);
	}
	
	public GGizException (String msg, Throwable throwable) {
		super (msg, throwable);
	}
	
	public GGizException (Throwable throwable) {
		super (throwable);
	}

	public GGizException (GGizExceptionCodeEnum codException) {
		super (GPoperties.getMessage(codException));
	}

	public GGizException (GGizExceptionCodeEnum codException, String strAdd) {
		super (GPoperties.getMessage(codException, strAdd));
	}
}
