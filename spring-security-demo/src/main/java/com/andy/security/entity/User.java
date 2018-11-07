package com.andy.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * @author Leone
 * @since 2017-11-07
 **/
@Data
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String account;

    private String password;

    private String description;

    private Integer age;

    private Date createTime;

    private boolean deleted;

    public User() {
    }

    public User(String account, String password, String description, Integer age, Date createTime, Boolean deleted) {
        this.account = account;
        this.password = password;
        this.description = description;
        this.age = age;
        this.createTime = createTime;
        this.deleted = deleted;
    }


    public interface SimpleUserView {
    }

    public interface DetailUserView extends SimpleUserView {
    }

}

