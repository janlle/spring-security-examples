package com.andy.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author: lyon
 * @since: 2018-04-07
 **/
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
