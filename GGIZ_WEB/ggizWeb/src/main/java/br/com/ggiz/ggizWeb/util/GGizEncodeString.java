package br.com.ggiz.ggizWeb.util;

import java.util.Base64;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public final class GGizEncodeString {

	private GGizEncodeString () {}
	
	public static final String encode (String content) {
		String encoded = Base64.getEncoder().
				encodeToString(content.getBytes());
		
		encoded = shuffle(encoded);
		
		return encoded;
	}
	
	private static String shuffle (String strEncoded) {
		
	
		String nRetStr;
		int sEc = strEncoded.length();
		sEc = (sEc/2);
		
		CharSequence chSequence1 = strEncoded.subSequence(0, sEc);
		CharSequence chSequence2 = strEncoded.subSequence(sEc, strEncoded.length());
		nRetStr = String.format("%s%s", chSequence2.toString(), chSequence1.toString());
		
		return nRetStr;
	}
}
