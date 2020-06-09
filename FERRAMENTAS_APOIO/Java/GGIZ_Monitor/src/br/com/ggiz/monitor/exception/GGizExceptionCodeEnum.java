package br.com.ggiz.monitor.exception;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public enum GGizExceptionCodeEnum {

	FILE_SINTAX_EXCEPTION ("ERROR001"),
	IO_EXCEPTION_URI     ("ERROR002"),
	ERROR_LOAD_LOOK_AND_FEEL ("ERROR003"),
	ERROR_LOAD_RESOURCE_COMP ("ERROR004");
	
	public final String optException;
	
	private GGizExceptionCodeEnum (final String optException) {
		this.optException = optException;
	}
}
