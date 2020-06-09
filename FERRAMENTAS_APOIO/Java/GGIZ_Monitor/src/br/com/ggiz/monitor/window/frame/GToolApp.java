package br.com.ggiz.monitor.window.frame;

import java.awt.Cursor;
import java.io.File;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import br.com.ggiz.monitor.engine.GPoperties;
import br.com.ggiz.monitor.exception.GGizException;
import br.com.ggiz.monitor.exception.GGizExceptionCodeEnum;

/**
 * 
 *@author Weber Alves dos Santos (Pinablink)
 *
 */
public class GToolApp {
       
	private JToolBar gToolBar;
	
	private JButton  gButtonSerializeCall;
	private static final String BUT_CALL_ICON_TOOL_TIP = "toolBarCmd1";
	private static final String BUT_CALL_ICON_PATH = "/br/com/ggiz/monitor/view/icon/gbin.png";
	private Icon     gButCallIcon;
	
	private JButton gButtonClearCall;
	private static final String BUT_CALL_CLEAN_ICON_TOOL_TIP = "toolBarCmd2";
	private static final String BUT_CALL_CLEAN_ICON_PATH = "/br/com/ggiz/monitor/view/icon/clearMem.png";
	private Icon gButCleanCallIcon;
	
	public GToolApp () 
			throws GGizException {
		
		super();
		this.createImgIcon();
		this.createButton();
		this.createToolBar();
	}
	
	
	private void createImgIcon () 
			throws GGizException {
	    
		try {
			
			URL resIconButCall = this.getClass().getResource(BUT_CALL_ICON_PATH);
			File fileIconButCall = new File (resIconButCall.toURI());
			this.gButCallIcon = new ImageIcon (fileIconButCall.getPath());
			
			URL resIconButCleanCall = this.getClass().getResource(BUT_CALL_CLEAN_ICON_PATH);
			File fileIconButCleanCall = new File (resIconButCleanCall.toURI());
			this.gButCleanCallIcon = new ImageIcon (fileIconButCleanCall.getPath());
			
		} catch (Exception e) {
			throw new GGizException(GGizExceptionCodeEnum.ERROR_LOAD_RESOURCE_COMP);
		}
	
	}
	
	private void createButton () {
		
		this.gButtonSerializeCall = new JButton(this.gButCallIcon);
		this.gButtonSerializeCall.setToolTipText(GPoperties.getLabel(BUT_CALL_ICON_TOOL_TIP));
		this.gButtonSerializeCall.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		this.gButtonClearCall = new JButton (this.gButCleanCallIcon);
		this.gButtonClearCall.setToolTipText(GPoperties.getLabel(BUT_CALL_CLEAN_ICON_TOOL_TIP));
		this.gButtonClearCall.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	private void createToolBar () {

		this.gButCallIcon = new ImageIcon ();
		this.gToolBar = new JToolBar();
        this.gToolBar.add(this.gButtonSerializeCall);
        this.gToolBar.add(this.gButtonClearCall);
        this.gToolBar.setFloatable(false);
        this.gToolBar.setRollover(true);
	}
	
	public JToolBar getToolBar () {
		return this.gToolBar;
	}
}
