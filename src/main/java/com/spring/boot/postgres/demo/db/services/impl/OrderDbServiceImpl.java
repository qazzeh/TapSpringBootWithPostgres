package com.spring.boot.postgres.demo.db.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.postgres.demo.beans.OrdersBean;
import com.spring.boot.postgres.demo.db.services.OrderDbService;
import com.spring.boot.postgres.demo.entites.Orders;
import com.spring.boot.postgres.demo.repo.OrdersRepo;

@Transactional
@Service
public class OrderDbServiceImpl implements OrderDbService {

	@Autowired
	OrdersRepo ordersRepo;

	/**
	 * 
	 */
	@Override
	public List<OrdersBean> fetchAllOrdersFromDatabase() {
		List<Orders> listFromDatabase = ordersRepo.findAll();

		List<OrdersBean> BizList = new ArrayList<OrdersBean>();
		listFromDatabase.stream().map(order -> BizList.add(new OrdersBean(order))).collect(Collectors.toList());

		return BizList;
	}

}
