package com.andy.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;


/**
 * @Description:
 * @Author: Mr.lyon
 * @CreateBy: 2018-05-19 22:18
 **/
public class AndySpringSocialConfigurer extends SpringSocialConfigurer {
	
	private String filterProcessesUrl;
	
	public AndySpringSocialConfigurer(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected <T> T postProcess(T object) {
		SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
		filter.setFilterProcessesUrl(filterProcessesUrl);
		return (T) filter;
	}

}
