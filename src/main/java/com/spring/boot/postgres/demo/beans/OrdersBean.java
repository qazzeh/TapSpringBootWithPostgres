package com.spring.boot.postgres.demo.beans;

import com.spring.boot.postgres.demo.entites.Orders;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class OrdersBean {
	private Integer id;
	private String orderName;
	private String orderDescription;
	private PersonBean personId;

	public OrdersBean(Orders orders) {
		this.setId(orders.getId());
		this.setOrderName(orders.getOrderName());
		this.setOrderDescription(orders.getOrderDescription());
		if (orders.getPersonId() != null) {
			this.setPersonId(new PersonBean(orders.getPersonId()));
		}
	}

	public Orders createEntity() {
		Orders orders = new Orders();
		orders.setId(this.getId());
		orders.setOrderName(this.getOrderName());
		orders.setOrderDescription(this.getOrderDescription());
		orders.setPersonId(this.getPersonId().createEntity());
		return orders;
	}
}
