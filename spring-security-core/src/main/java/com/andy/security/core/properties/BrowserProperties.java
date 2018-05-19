package com.andy.security.core.properties;

import lombok.Data;

@Data
public class BrowserProperties {

	private String loginPage = "/andy-login.html";
	
	private LoginType loginType = LoginType.JSON;

	private int rememberMeSeconds = 3600;


}
