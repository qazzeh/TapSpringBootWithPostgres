package com.spring.boot.postgres.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.postgres.demo.entites.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Long> {

}
