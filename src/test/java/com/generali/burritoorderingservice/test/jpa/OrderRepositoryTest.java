package com.generali.burritoorderingservice.test.jpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.generali.burritoorderingservice.com.generali.burritoorderingservice.model.entity.Order;
import com.generali.burritoorderingservice.com.generali.burritoorderingservice.repository.BurritoOrderingRepository;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

@DataJpaTest
public class OrderRepositoryTest {
	
	@Autowired
	private BurritoOrderingRepository repo;
	
	UUID uid;
	
	@Test
	public void saveOrder() {
		
		Order order = new Order();
		uid = UUID.randomUUID();
		order.setId(uid);
		String sorder = createOrder();
		order.setOrder_s(sorder);
		order.setCreated_on(LocalDateTime.now());
		Order savedOrder = repo.save(order);
		assertNotNull(savedOrder);
	}
	
	@Test
	public void getOrder() {
		Order savedOrder = repo.getById(uid);
		assertNotNull(savedOrder);
	}
	
	private String createOrder() {
		HashMap<String, ArrayList<String>> orderMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String>tortilla = Lists.newArrayList("corn");
		ArrayList<String>protein = Lists.newArrayList("bean");
		ArrayList<String>vegy = Lists.newArrayList("cabbage");
		ArrayList<String>salsa = Lists.newArrayList("hot");
		ArrayList<String>extras =Lists.newArrayList("avocado");
		orderMap.put("Tortilla", tortilla);
		orderMap.put("Protein", protein);
		orderMap.put("Vegetables", vegy);
		orderMap.put("Salsa", salsa);
		orderMap.put("Extras", extras);
		Gson gson = new Gson();
		return gson.toJson(orderMap);
	}

}
