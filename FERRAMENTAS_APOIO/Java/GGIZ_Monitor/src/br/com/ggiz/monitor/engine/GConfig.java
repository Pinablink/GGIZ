package br.com.ggiz.monitor.engine;

import java.io.File;
import java.io.IOException;
import br.com.ggiz.monitor.engine.gabstract.GLife;
import br.com.ggiz.monitor.exception.GGizException;
import br.com.ggiz.monitor.exception.GGizExceptionCodeEnum;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GConfig 
			extends GLife {

	private String pathConfigData;
	private File   fileConfig;
	
	public GConfig () {
		super ();
	}

	
	private void createDir () {
	  File file = new File (".\\" + GConstant.CONFIG_DIR);
      boolean exixtDir = file.exists();
		 if (!exixtDir) {
			file.mkdir();
		 } 
	}
	
	
	@Override
	public void init() throws GGizException {
		
		final String FILE_PATH = String.format(".\\%s\\%s.%s", GConstant.CONFIG_DIR,
            	   											   GConstant.OBJ_CONFIG,
            	   											   GConstant.OBJ_EXT);
		this.createDir();
		
		try {
			
			this.fileConfig 	= new File (FILE_PATH);
			boolean exists      = this.fileConfig.exists();
			
			if (!exists) {
				boolean created = this.fileConfig.createNewFile();
				
				if (!created) {
					throw new GGizException(GGizExceptionCodeEnum.FILE_SINTAX_EXCEPTION, FILE_PATH);
				}
				
			} 
			
		} catch (IOException ioexception) {
			throw new GGizException(GGizExceptionCodeEnum.IO_EXCEPTION_URI, FILE_PATH);
		}
	}
	
}
