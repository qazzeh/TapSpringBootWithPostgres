package com.spring.boot.postgres.demo.db.services;

import java.util.List;

import com.spring.boot.postgres.demo.beans.OrdersBean;

public interface OrderDbService {

	List<OrdersBean> fetchAllOrdersFromDatabase();

}
