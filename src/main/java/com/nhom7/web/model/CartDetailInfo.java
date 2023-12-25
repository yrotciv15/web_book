package com.nhom7.web.model;

import com.nhom7.web.entity.Book;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDetailInfo {
	private Book book;
	private Integer quantity;
    private Integer status;


	public CartDetailInfo() {
        this.status = 0;
        this.quantity = 0;
    }
    public Integer getAmount() {
        return this.book.getPrice() * this.quantity;
    }
	
}
