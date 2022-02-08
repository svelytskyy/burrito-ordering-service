package com.generali.burritoorderingservice.com.generali.burritoorderingservice.exception;

import lombok.Data;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;

import com.generali.burritoorderingservice.com.generali.burritoorderingservice.model.BaseResponse;

@Data
public class BarritOrderException extends Exception{

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private Exception e;
	private BaseResponse response;
	private HttpStatus httpstatus;
	private Logger logger;
	public BarritOrderException(String code, String message, Exception e, BaseResponse response, HttpStatus httpstatus,
			Logger logger) {
		super();
		this.code = code;
		this.message = message;
		this.e = e;
		this.response = response;
		this.httpstatus = httpstatus;
		this.logger = logger;
	}
	
	public BarritOrderException(String message) {
		super(message);
		this.message = message;
	}


}
