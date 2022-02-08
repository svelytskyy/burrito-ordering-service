package com.generali.burritoorderingservice.com.generali.burritoorderingservice.repository;

import  com.generali.burritoorderingservice.com.generali.burritoorderingservice.model.entity.Order;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("orderRepo")
public interface BurritoOrderingRepository extends JpaRepository<Order, UUID>{

}
