package net.ggiz.view.eeprom.impl;

import net.ggiz.view.eeprom.jinterface.MemoDataInterface;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class MemoDataSerialImpl implements MemoDataInterface {

	
	@Override
	public void processData(char dataStream) {
		System.out.println (dataStream);
	}

}
