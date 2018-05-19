package com.andy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Users implements Serializable {
	
	public Users(Integer id, Date birthday, String username, String password, double salary) {
		super();
		this.id = id;
		this.birthday = birthday;
		this.username = username;
		this.password = password;
		this.salary = salary;
	}
	public Users() {
		super();
	}
	
	public interface SimpleUserView{};

	public interface DetailUserView extends SimpleUserView{};

	private Integer id;

	private Date birthday;

	private String username;
	
	private String password;
	
	private double salary;



}

