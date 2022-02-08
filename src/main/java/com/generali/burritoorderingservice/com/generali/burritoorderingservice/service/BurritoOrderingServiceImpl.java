package com.generali.burritoorderingservice.com.generali.burritoorderingservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.generali.burritoorderingservice.com.generali.burritoorderingservice.exception.BarritOrderException;
import com.generali.burritoorderingservice.com.generali.burritoorderingservice.model.entity.Order;
import com.generali.burritoorderingservice.com.generali.burritoorderingservice.repository.BurritoOrderingRepository;
import com.google.gson.Gson;

@Service
public class BurritoOrderingServiceImpl implements BurritoOrderingService{
	
	@Qualifier("orderRepo")
	@Autowired BurritoOrderingRepository orderRepo;
	
	@Transactional
	public UUID createOrder( HashMap<String, ArrayList<String> > order) throws BarritOrderException {
		BurritoOrderingProcessor.validateOrder(order);
		Order orderEntity = new Order();
		Gson gson = new Gson(); 
		String jsonOrder = gson.toJson(order);
		System.out.println(jsonOrder);
		orderEntity.setOrder_s(jsonOrder);
		orderEntity.setCreated_on(LocalDateTime.now());
		Order entity = orderRepo.save(orderEntity);
		return entity.getId();
	}

	@Transactional
	public Order getOrder(UUID orderid) throws BarritOrderException{
		Optional<Order> order = orderRepo.findById(orderid);
		if (!(order.isEmpty() || order.isPresent())) throw new BarritOrderException("Order doesnt exists");
		return order.get();
	}

}
