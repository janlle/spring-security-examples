package com.andy.validate.code;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 短信验证码实体
 *
 * @author: Mr.lyon
 * @createBy: 2018-04-7 18:02
 **/
@Data
public class ValidateCode {

    private String code;

    private LocalDateTime expiredTime;

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

    public ValidateCode() {
    }


}
