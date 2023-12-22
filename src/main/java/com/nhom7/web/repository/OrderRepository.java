package com.nhom7.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom7.web.entity.Order;
import com.nhom7.web.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByUser (User user);
}

