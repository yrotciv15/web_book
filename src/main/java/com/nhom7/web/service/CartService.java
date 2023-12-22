package com.nhom7.web.service;

import com.nhom7.web.entity.Book;
import com.nhom7.web.entity.Cart;
import com.nhom7.web.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
@Autowired CartRepository cartRepository;

    public List<Cart> findAll(){
        return cartRepository.findAll();
    }
    public Cart findById(Integer id){   return cartRepository.findById(id).get();}
    public Cart save(Cart cart){    return cartRepository.save(cart);}
    public void deleteCart(Cart cart){
        cartRepository.delete(cart);
    }

    public List<Cart> findByBook(Book book){    return cartRepository.findByBook(book);}
}
