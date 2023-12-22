package com.nhom7.web.service;

import java.util.List;

import com.nhom7.web.entity.Book;
import com.nhom7.web.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nhom7.web.entity.OrderDetail;
import com.nhom7.web.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
@Autowired OrderDetailRepository orderDetailRepository;
	
	public List<OrderDetail> findAll(){
		return orderDetailRepository.findAll();
	}
	
	public OrderDetail findById(Integer id) {
		return orderDetailRepository.findById(id).get();
	}
	
	public OrderDetail save(OrderDetail order) {
		return orderDetailRepository.save(order);
	}
	
	public void delete(OrderDetail order) {
		orderDetailRepository.delete(order);
	}
	
	public Page<OrderDetail> findByLimit(Integer page, Integer limit){
		Page<OrderDetail> orders = orderDetailRepository.findAll(PageRequest.of(page, limit));
		return orders;
	}

	public List<OrderDetail> findByOrder(Order order){
		return orderDetailRepository.findByOrder(order);
	}

	public List<OrderDetail> findbyBook(Book book){
		return orderDetailRepository.findByBook(book);
	}

}
