/**
 *
 */
package com.andy.security.core.social.weixin.api;


/**
 * 微信API调用接口
 *
 * @author Leone
 * @since 2018-05-19
 **/
public interface Weixin {

    WeixinUserInfo getUserInfo(String openId);

}
