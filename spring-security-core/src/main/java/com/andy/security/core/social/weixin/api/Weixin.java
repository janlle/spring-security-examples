/**
 * 
 */
package com.andy.security.core.social.weixin.api;


 /**
 *  微信API调用接口
 * @author: Mr.lyon
 * @CreateBy: 2018-05-19 22:18
 **/
public interface Weixin {

	WeixinUserInfo getUserInfo(String openId);

}
