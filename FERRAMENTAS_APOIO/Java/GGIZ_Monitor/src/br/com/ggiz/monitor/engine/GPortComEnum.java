package br.com.ggiz.monitor.engine;

import java.io.Serializable;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public enum GPortComEnum implements Serializable {
	
	COM1  (1),
	COM2  (2),
	COM3  (3),
	COM4  (4),
	COM5  (5),
	COM6  (6),
	COM7  (7),
	COM8  (8),
	COM9  (9),
	COM10 (10),
	COM14 (11);
	
	public final int portCom;
	
	private GPortComEnum (final int portCom) {
		this.portCom = portCom;
	}

}
