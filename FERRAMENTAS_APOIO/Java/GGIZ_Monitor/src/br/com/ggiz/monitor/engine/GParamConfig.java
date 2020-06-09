package br.com.ggiz.monitor.engine;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GParamConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2522271787791050547L;

	private GBaudeRateEnum gBaudeRate;
	
	private GPortComEnum   gPortCom;
	
	private boolean isConfig;
	
}
