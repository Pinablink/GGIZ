package br.com.ggiz.monitor.main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.ggiz.monitor.engine.GConfig;
import br.com.ggiz.monitor.engine.GPoperties;
import br.com.ggiz.monitor.exception.GGizException;
import br.com.ggiz.monitor.exception.GGizExceptionCodeEnum;
import br.com.ggiz.monitor.window.frame.GappFrame;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class Monitor {

	public static void main (final String[] arguments) {
		GConfig gConfig = new GConfig ();
		
		try {
			
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			gConfig.init();
			GappFrame gappFrame = new GappFrame();
			gappFrame.enableVisible();
		
		} catch (ClassNotFoundException classNotFoundException) {
			JOptionPane.showMessageDialog(null, GPoperties.getMessage(GGizExceptionCodeEnum.ERROR_LOAD_LOOK_AND_FEEL));
		} catch (InstantiationException instantiationException) {
			JOptionPane.showMessageDialog(null, GPoperties.getMessage(GGizExceptionCodeEnum.ERROR_LOAD_LOOK_AND_FEEL));
		} catch (IllegalAccessException illegalAcessException) {
			JOptionPane.showMessageDialog(null, GPoperties.getMessage(GGizExceptionCodeEnum.ERROR_LOAD_LOOK_AND_FEEL));
		} catch (UnsupportedLookAndFeelException uex) {
			JOptionPane.showMessageDialog(null, GPoperties.getMessage(GGizExceptionCodeEnum.ERROR_LOAD_LOOK_AND_FEEL));
		} catch (GGizException ggizException) {
			JOptionPane.showMessageDialog(null, ggizException.getMessage());
		}
	}
}
