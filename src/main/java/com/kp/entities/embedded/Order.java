package com.kp.entities.embedded;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_order_")
public class Order {
	
	@EmbeddedId
	private OrderId orderId;
	
	private String orderInfo;
	
	
	
	
	

}
