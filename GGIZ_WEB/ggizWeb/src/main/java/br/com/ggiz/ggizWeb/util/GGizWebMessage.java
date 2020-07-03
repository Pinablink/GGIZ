package br.com.ggiz.ggizWeb.util;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGizWebMessage {

	private String userNotFound;
	private String errCadUser;
	private String errDupUser;
	private String errDupEmail;
	private String errDupEmailUser;
			
	public String getUserNotFound() {
		return userNotFound;
	}

	public void setUserNotFound(String userNotFound) {
		this.userNotFound = userNotFound;
	}

	public String getErrCadUser() {
		return errCadUser;
	}

	public void setErrCadUser(String errCadUser) {
		this.errCadUser = errCadUser;
	}

	public String getErrDupUser() {
		return errDupUser;
	}

	public void setErrDupUser(String errDupUser) {
		this.errDupUser = errDupUser;
	}

	public String getErrDupEmail() {
		return errDupEmail;
	}

	public void setErrDupEmail(String errDupEmail) {
		this.errDupEmail = errDupEmail;
	}

	public String getErrDupEmailUser() {
		return errDupEmailUser;
	}

	public void setErrDupEmailUser(String errDupEmailUser) {
		this.errDupEmailUser = errDupEmailUser;
	}
	
	
}
