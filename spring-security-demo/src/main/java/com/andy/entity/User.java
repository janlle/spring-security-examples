package com.andy.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(columnDefinition = "varchar(64) not null comment '名称'")
    private String username;

    @Column(columnDefinition = "varchar(64) not null comment '账号'")
    private String account;

    @Column(columnDefinition = "varchar(64) not null comment '密码'")
    private String password;

    @Column(columnDefinition = "varchar(24) not null comment '邮箱'")
    private String email;

    @Column(columnDefinition = "varchar(48) not null comment '盐'")
    private String salt;

    @Column(columnDefinition = "tinyint not null default false comment '禁用'")
    private Boolean disable;

    @Column(columnDefinition = "tinyint not null default false comment '删除'")
    private Boolean deleted;

    @Column(columnDefinition = "timestamp not null default current_timestamp comment '创建时间'")
    private Date createTime;

    @Column(columnDefinition = "timestamp not null default current_timestamp comment '修改时间'")
    private Date updateTime;

    public User(String username, String account, String password, String email, String salt) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.email = email;
        this.salt = salt;
    }

    public User() {
        super();
    }

    public interface SimpleUserView {
    }

    public interface DetailUserView extends SimpleUserView {
    }

}

