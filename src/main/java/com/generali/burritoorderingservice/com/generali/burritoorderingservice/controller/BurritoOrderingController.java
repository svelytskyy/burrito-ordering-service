package com.generali.burritoorderingservice.com.generali.burritoorderingservice.controller;

/*
{
"Tortilla" : ["corn"],
"Protein" : ["bean"],
"Vegetables":["corn","cabbage"],
"Salsa":["hot"],
"Extras":["avocado"]
}
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generali.burritoorderingservice.com.generali.burritoorderingservice.exception.BarritOrderException;
import com.generali.burritoorderingservice.com.generali.burritoorderingservice.model.BaseResponse;
import com.generali.burritoorderingservice.com.generali.burritoorderingservice.model.entity.Order;
import com.generali.burritoorderingservice.com.generali.burritoorderingservice.service.BurritoOrderingService;

@RestController
public class BurritoOrderingController {
	
	@Autowired 
	BurritoOrderingService service;
	
	@PostMapping(value="/orders", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse createOrder(@RequestBody HashMap<String, ArrayList<String> > order) throws BarritOrderException {
		UUID id = service.createOrder(order);
		return new BaseResponse("200","Order " + id + " was created" );
	}
	
	@GetMapping(value="/orders/{orderid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Order getOrder(@PathVariable(required=true) UUID orderid) throws BarritOrderException {
		return service.getOrder(orderid);
	}

}
