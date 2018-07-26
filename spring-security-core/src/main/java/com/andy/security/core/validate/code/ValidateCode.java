package com.andy.security.core.validate.code;

import lombok.Data;
import java.time.LocalDateTime;
/**
 * 短信验证码实体
 * @author: Mr.lyon
 * @createBy: 2018-04-7 18:02
 **/
@Data
public class ValidateCode {

    private String code;

    private LocalDateTime exprieTime;

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(exprieTime);
    }

    public ValidateCode(String code, int expriedTime) {
        this.code = code;
        this.exprieTime = LocalDateTime.now().plusSeconds(expriedTime);
    }

    public ValidateCode(String code, LocalDateTime exprieTime) {
        this.code = code;
        this.exprieTime = exprieTime;
    }

    public ValidateCode() {
    }


}
