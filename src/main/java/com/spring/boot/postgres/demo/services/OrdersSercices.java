package com.spring.boot.postgres.demo.services;

import java.util.List;

import com.spring.boot.postgres.demo.beans.OrdersBean;

public interface OrdersSercices {

	List<OrdersBean> getAllOrders();

}
