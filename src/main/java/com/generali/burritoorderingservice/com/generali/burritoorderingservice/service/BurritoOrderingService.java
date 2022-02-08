package com.generali.burritoorderingservice.com.generali.burritoorderingservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.generali.burritoorderingservice.com.generali.burritoorderingservice.exception.BarritOrderException;
import com.generali.burritoorderingservice.com.generali.burritoorderingservice.model.entity.Order;

public interface BurritoOrderingService {
	
	public UUID createOrder(  HashMap<String, ArrayList<String> > order ) throws BarritOrderException;
	public Order getOrder(UUID orderid) throws BarritOrderException;

}
