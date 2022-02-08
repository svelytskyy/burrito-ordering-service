package com.generali.burritoorderingservice.com.generali.burritoorderingservice.model;

import lombok.Data;

@Data
public class BaseResponse {
	
	public BaseResponse(String code, String meassage) {
		super();
		this.code = code;
		this.meassage = meassage;
	}
	
	public BaseResponse() {
	}

	private String code;
	private String meassage;
	
}
