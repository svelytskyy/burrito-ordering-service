package com.generali.burritoorderingservice.com.generali.burritoorderingservice.model.entity;

/*
 * 
 * 
{
"Tortilla" : ["corn"],
"Protein" : ["bean"],
"Vegetables":["corn","cabbage"],
"Salsa":["hot"],
"Extras":["avocado"]
}
 * 
 */

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders", schema="public")
public class Order {
	
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="id", columnDefinition = "uuid", updatable = false )
	private UUID id;
    @Column(columnDefinition="TEXT")
	private String order_s;
	private LocalDateTime created_on;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getOrder_s() {
		return order_s;
	}
	public void setOrder_s(String order_s) {
		this.order_s = order_s;
	}
	public LocalDateTime getCreated_on() {
		return created_on;
	}
	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}
	
	

}
