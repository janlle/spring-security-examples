package com.andy.security.core.property;

import lombok.Data;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-09-18
 **/
@Data
public class BrowserProperties {

	private String loginPage = "/andy-login.html";
	
	private LoginType loginType = LoginType.JSON;

	private int rememberMeSeconds = 3600;


}
