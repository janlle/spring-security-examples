package com.andy.security.browser.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleResponse {

	private Object content;

	private String msg;

	private Integer code;

	public SimpleResponse(Object content) {
		this.content = content;
	}

}
