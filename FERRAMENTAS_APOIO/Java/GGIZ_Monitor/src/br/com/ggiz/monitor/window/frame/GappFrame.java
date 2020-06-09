package br.com.ggiz.monitor.window.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.ggiz.monitor.engine.GConstant;
import br.com.ggiz.monitor.engine.GPoperties;
import br.com.ggiz.monitor.exception.GGizException;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GappFrame {

	private static final String REF_FRAME_TITLE = "frameAppTitulo";
	private GMenuApp gMenuApp;
	private GToolApp gToolApp;
	private JFrame 	 gFrame;
	private JPanel   gPanelMain;
	
	public GappFrame () 
			throws GGizException {
		super ();
		//Prioridade de Montagem
		this.createCompResource();
		this.createFrame();
		this.assemblyPanels();
		this.assemblyFrame();
	}
	
	private void createCompResource () 
			throws GGizException {
		this.gMenuApp = new GMenuApp();
		this.gToolApp = new GToolApp();
	}
	
	private void createFrame () {
		this.gFrame = new JFrame (GPoperties.getLabel(REF_FRAME_TITLE));
	    this.gFrame.setResizable(false);
		this.gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gFrame.setLayout(new BorderLayout());

		//Refatorar quando existirem outros objetos
		this.gFrame.setSize(new Dimension (GConstant.LEN_WIDTH_FRAME_MAIN, GConstant.LEN_HEIGHT_FRAME_MAIN));
	}
	
	private void assemblyFrame () {
		this.gFrame.setJMenuBar(this.gMenuApp.getJMenuBar());
		this.gFrame.add(BorderLayout.CENTER, this.gPanelMain);
	}
	
	public void enableVisible () {
		//Retornar quando estiver pronto
		//this.gFrame.pack();
		this.gFrame.setEnabled(true);
		this.gFrame.setVisible(true);
	}
	
	private void assemblyPanels () {
		this.gPanelMain = new JPanel (new BorderLayout());
		this.gPanelMain.add(BorderLayout.NORTH, this.gToolApp.getToolBar());
	}
	
}
