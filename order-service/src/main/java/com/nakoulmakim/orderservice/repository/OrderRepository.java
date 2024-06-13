package com.nakoulmakim.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nakoulmakim.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
