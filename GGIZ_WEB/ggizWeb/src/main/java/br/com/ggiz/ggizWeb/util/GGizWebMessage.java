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
	private String newsNotFound;
	private String newsLerNotFound;
	private String broadcastRecpNotFound;
			
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

	public String getNewsNotFound() {
		return newsNotFound;
	}

	public void setNewsNotFound(String newsNotFound) {
		this.newsNotFound = newsNotFound;
	}

	public String getNewsLerNotFound() {
		return newsLerNotFound;
	}

	public void setNewsLerNotFound(String newsLerNotFound) {
		this.newsLerNotFound = newsLerNotFound;
	}

	public String getBroadcastRecpNotFound() {
		return broadcastRecpNotFound;
	}

	public void setBroadcastRecpNotFound(String broadcastRecpNotFound) {
		this.broadcastRecpNotFound = broadcastRecpNotFound;
	}
	
	
}
