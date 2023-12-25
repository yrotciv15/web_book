package com.nhom7.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.nhom7.web.model.CartDetailInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private int total_cost;
    private int number;
    private String created_at;
    private String updated_at;

    public int getAmount(){
        return this.book.getPrice() * this.number;
    }
}
