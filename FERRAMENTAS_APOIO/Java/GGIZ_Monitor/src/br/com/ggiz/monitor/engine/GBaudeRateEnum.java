package br.com.ggiz.monitor.engine;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public enum GBaudeRateEnum implements Serializable {

	CBR_110    (1),
    CBR_300    (2),
    CBR_600    (3),
    CBR_1200   (4),
    CBR_2400   (5),
    CBR_4800   (6),
    CBR_9600   (7),
    CBR_14400  (8),
    CBR_19200  (9),
    CBR_38400  (10),
    CBR_57600  (11),
    CBR_115200 (12),
    CBR_128000 (13),
    CBR_256000 (14);
	
	public final int optBaude;
	
	private GBaudeRateEnum (final int optBaude) {
		this.optBaude = optBaude;
	}
}
