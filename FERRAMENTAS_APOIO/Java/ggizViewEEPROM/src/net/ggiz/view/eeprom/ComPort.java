package net.ggiz.view.eeprom;


/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class ComPort {

	
	public native int[] readDataExtern(int optPort);
	
	public ComPort () {
		super ();
	}
	
	
	public void processData () {
		
	}
}
