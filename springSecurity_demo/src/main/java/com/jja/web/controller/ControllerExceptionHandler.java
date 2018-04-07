package com.jja.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jja.exception.UserNotExistException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotExistException.class)
	public Map<String, Object> userNotExistException(UserNotExistException e){
		Map<String, Object> map = new HashMap<>();
		map.put("id", e.getId());
		map.put("message", e.getMessage());
		return map;
	}
	
	
}
