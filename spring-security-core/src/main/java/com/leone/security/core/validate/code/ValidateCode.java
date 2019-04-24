package com.leone.security.core.validate.code;

import java.time.LocalDateTime;

/**
 * 短信验证码实体
 *
 * @author Leone
 * @since 2018-04-7
 **/
public class ValidateCode {

    private String code;

    private LocalDateTime expiredTime;

    public ValidateCode() {
    }

    public boolean isExpiredTime() {
        return LocalDateTime.now().isAfter(expiredTime);
    }

    public ValidateCode(String code, int expiredTime) {
        this.code = code;
        this.expiredTime = LocalDateTime.now().plusSeconds(expiredTime);
    }

    public ValidateCode(String code, LocalDateTime expiredTime) {
        this.code = code;
        this.expiredTime = expiredTime;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }
}
