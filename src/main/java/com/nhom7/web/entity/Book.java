package com.nhom7.web.entity;

import com.nhom7.web.service.OrderService;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	private String title;
	private String date_publication;
	private String description;
	
	@Lob
	@Column(name = "image", length = Integer.MAX_VALUE, nullable = true)
	@ToString.Exclude
	private byte[] image;
	
	@Transient
	private MultipartFile fileData;
	
	@Transient
	private boolean newBook;
	
	@OneToMany(mappedBy = "book")
	@ToString.Exclude
	private Collection<OrderDetail> orderDetailList;

	public boolean checkOderDetail(){
		Collection<OrderDetail> orderDetails = this.orderDetailList;
		for(OrderDetail orderDetail : orderDetails){
			Order order = orderDetail.getOrder();
			if(order.getStatus().equals("Đang chờ duyệt")){
				return true;
			}
		}
		return false;
	}

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@ToString.Exclude
	private Collection<Comment> commentList;
	
	private int price;
	private int number_page;
	private int number_sold;
	private int number_in_stock;
	private String created_at;
	private String updated_at;

}