package br.com.ggiz.monitor.window.frame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.ggiz.monitor.engine.GPoperties;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GMenuApp {

	private JMenuBar  gMenuBar;
	private JMenu     gMenuSistema;
	private JMenuItem gMenuItemObjBin;
	private static final String REF_MENU1 = "menu1";
	private static final String REF_MENU1_ITEM1 = "menu1Item1";
	
	public GMenuApp () {
		super ();
		this.createMenu();
	}
	
	public JMenuBar getJMenuBar () {
		return this.gMenuBar;
	}
	
	public void createMenu () {
		this.gMenuBar = new JMenuBar();
		this.gMenuSistema = new JMenu(GPoperties.getLabel(REF_MENU1));
		this.gMenuItemObjBin = new JMenuItem(GPoperties.getLabel(REF_MENU1_ITEM1));
		
		this.gMenuSistema.add(gMenuItemObjBin);
		this.gMenuBar.add(gMenuSistema);
	}
}
