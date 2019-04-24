package com.leone.security.exception;

/**
 * @author Leone
 * @since 2017-11-6
 */
public class UserNotExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
