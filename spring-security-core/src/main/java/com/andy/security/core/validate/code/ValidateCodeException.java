package com.andy.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Leone
 * @since 2018-03-25 18:59
 **/
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
