package br.com.ggiz.monitor.engine;

import java.util.ResourceBundle;

import br.com.ggiz.monitor.exception.GGizExceptionCodeEnum;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public final class GPoperties {

	private static final ResourceBundle MESSAGE_SYS = ResourceBundle.
			getBundle("br.com.ggiz.monitor.view.properties.messages");
	

	private static final ResourceBundle LABEL_SYS = ResourceBundle.
			getBundle("br.com.ggiz.monitor.view.properties.labels");
	
	private GPoperties() {}
	
	
	public static final String getLabel (String labelRef) {
		//frameAppTitulo
        boolean isContainLabel = LABEL_SYS.containsKey(labelRef);
		
		if (isContainLabel) 
			return LABEL_SYS.getString(labelRef);
			
		
		return "ERROR";
	}
	
	public static final String getMessage (GGizExceptionCodeEnum gcodeEnum, String add) {
		String strMessageReturn = GPoperties.getMessage(gcodeEnum);
		boolean isMessageOK = (strMessageReturn != null && strMessageReturn.contains("%s"));
		
		if (isMessageOK) 
			return String.format(strMessageReturn, add);
		
		return strMessageReturn;
	}
	
	public static final String getMessage (GGizExceptionCodeEnum gcodeEnum) {
		boolean isContainMessage = MESSAGE_SYS.containsKey(gcodeEnum.optException);
		
		if (isContainMessage) 
			return MESSAGE_SYS.getString(gcodeEnum.optException);
			
		
		return "Config Msg - Error Code " + gcodeEnum.optException;
	}
}
