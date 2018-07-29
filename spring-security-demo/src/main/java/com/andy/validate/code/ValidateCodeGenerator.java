package com.andy.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author: Mr.lyon
 * @createBy: 2018-04-07 09:18
 **/
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
