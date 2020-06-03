package net.ggiz.view.eeprom.main;

import net.ggiz.view.eeprom.ComPort;


/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class Main {

	public static void main (String[] arguments) {
		System.load("C:\\Ferramentas\\ComPort.dll");
		ComPort comPort = new ComPort ();
		int[] retorno = comPort.readDataExtern(1);
		
		for (int i = 0; i <= (retorno.length - 1); i++) {
			System.out.println (retorno[i]);
		}
	}
}
