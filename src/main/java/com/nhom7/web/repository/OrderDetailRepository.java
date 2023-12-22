package com.nhom7.web.repository;

import com.nhom7.web.entity.Book;
import com.nhom7.web.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import  org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhom7.web.entity.OrderDetail;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    List<OrderDetail> findByOrder(Order order);
    List<OrderDetail> findByBook(Book book);
}

