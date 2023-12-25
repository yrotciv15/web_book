package com.nhom7.web.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nhom7.web.entity.Book;
import com.nhom7.web.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartInfo {
	private User user;

	private List<CartDetailInfo> cartDetails = new ArrayList<CartDetailInfo>();

	private CartDetailInfo findLineByBookId(Integer id) {
		for (CartDetailInfo line : this.cartDetails) {
			if (line.getBook().getId() == id) {
				return line;
			}
		}
		return null;
	}

	public void addBook(Book book, Integer quantity) {
		CartDetailInfo line = this.findLineByBookId(book.getId());
		if (line == null) {
			line = new CartDetailInfo();
			line.setBook(book);
			line.setQuantity(0);
			this.cartDetails.add(line);
		}
		int newQuantity = line.getQuantity() + quantity;
		if (quantity <= 0) {
			this.cartDetails.remove(line);
		} else {
			line.setQuantity(newQuantity);
		}
	}

	public void updateBook(Integer id, Integer quantity) {
		CartDetailInfo line = this.findLineByBookId(id);
		if (line != null) {
			if (quantity <= 0)
				this.cartDetails.remove(line);
			else
				line.setQuantity(quantity);
		}
	}
	
	public Integer getTotalBooks() {
		Integer count = 0;
		for(CartDetailInfo cartDetailInfo : cartDetails) {
			count += cartDetailInfo.getQuantity();
		}
		return count;
	}

	public void removeBook(Integer id) {
		CartDetailInfo line = this.findLineByBookId(id);
		this.cartDetails.remove(line);
	}
	public void removeCartDetailInfor(){
		Iterator<CartDetailInfo> iterator = cartDetails.iterator();
		while (iterator.hasNext()) {
			CartDetailInfo cartDetailInfo = iterator.next();
			if (cartDetailInfo.getStatus() == 1) {
				iterator.remove(); // Sử dụng iterator để xóa phần tử an toàn
			}
		}
	}

	public boolean isEmpty() {
		return this.cartDetails.isEmpty();
	}

	public Integer getAmount() {
		Integer amount = 0;
		for (CartDetailInfo x : this.cartDetails) {
			if(x.getStatus() == 1){
				amount += x.getAmount();
			}
		}
		return amount;
	}
	
	public Integer getDeliveryCharges() {
		Long deliveryCharges = Math.round(getAmount() * 10 / 100.0);
		return Integer.valueOf(String.valueOf(deliveryCharges));
	}
	
	public Integer getTotalAmount() {
		return getAmount() + getDeliveryCharges();
	}
}
