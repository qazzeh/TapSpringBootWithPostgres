package com.spring.boot.postgres.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.postgres.demo.beans.OrdersBean;
import com.spring.boot.postgres.demo.db.services.OrderDbService;
import com.spring.boot.postgres.demo.services.OrdersSercices;

@Service
public class OrdersServiceImpl implements OrdersSercices {

	@Autowired
	OrderDbService orderDbService;

	@Override
	public List<OrdersBean> getAllOrders() {
		return orderDbService.fetchAllOrdersFromDatabase();
	}

}
