package com.andy.security.browser.support;

public class SimpleResponse {

	private Object content;

	private String msg;

	private Integer code;

	public SimpleResponse(Object content, String msg, Integer code) {
		this.content = content;
		this.msg = msg;
		this.code = code;
	}

	public SimpleResponse() {
	}

	public SimpleResponse(Object content) {
		this.content = content;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
