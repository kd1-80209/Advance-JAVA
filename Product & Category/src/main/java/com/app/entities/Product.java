package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = { "category" })
public class Product extends BaseEntity {

	@Column(name = "prod_name", length = 50, unique = true)
	private String prodName;

	@Column(name = "prod_descrip", length = 300)
	private String description;

	@Column(name = "prod_price")
	private double price;

	@Column(name = "avail_stock")
	private int availStock;

	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	@ManyToOne
	@JoinColumn(name = "cat_id", nullable = false)
	private Category category;

	public Product(String prodName, String description, double price, int availStock, LocalDate expiryDate) {
		super();
		this.prodName = prodName;
		this.description = description;
		this.price = price;
		this.availStock = availStock;
		this.expiryDate = expiryDate;
	}

}
