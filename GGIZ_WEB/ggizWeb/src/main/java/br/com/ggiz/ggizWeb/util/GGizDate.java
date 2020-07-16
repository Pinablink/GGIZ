package br.com.ggiz.ggizWeb.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public final class GGizDate {

	public final static String FORMAT_BR_DEFAULT = "dd/MM/yyyy";
	private GGizDate () {
		super();
	}
	
	public final static String getDateFormatStr (Date dateTarget) {
		
		SimpleDateFormat strDateFormat = new SimpleDateFormat (GGizDate.FORMAT_BR_DEFAULT);
		
		try {
			java.util.Date dt = new java.util.Date(dateTarget.getTime());
			return strDateFormat.format(dt);
		} catch (Exception ex) {
			
			return strDateFormat.format(new java.util.Date());
		}
		
	}
}
