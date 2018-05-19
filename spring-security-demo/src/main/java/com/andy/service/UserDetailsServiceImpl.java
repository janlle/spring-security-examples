package com.andy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService, SocialUserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//真实项目中是数据库中的密码，目前定义为abcd
		String password = passwordEncoder.encode("abcd");
		log.info("表单登录名是:{}",username);
		return buildUser(username);
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		log.info("社交登录ID是:{}",userId);
		return buildUser(userId);
	}

	private SocialUserDetails buildUser(String userId) {
		//真实项目中是数据库中的密码，目前定义为abcd
		String password = passwordEncoder.encode("abcd");
		log.info("数据库的密码是:{}",password);
		return new SocialUser(userId, password,
				true, true, true ,true,
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}
}
