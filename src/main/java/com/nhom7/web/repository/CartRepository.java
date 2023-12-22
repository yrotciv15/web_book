package com.nhom7.web.repository;

import com.nhom7.web.entity.Book;
import com.nhom7.web.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByBook(Book book);
}
