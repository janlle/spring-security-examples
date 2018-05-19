/**
 * 
 */
package com.andy.security.core.social.weixin.api;


 /**
 * @Description: 微信API调用接口
 * @Author: Mr.lyon
 * @CreateBy: 2018-05-19 22:18
 **/
public interface Weixin {

	WeixinUserInfo getUserInfo(String openId);

}
