package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

	@Column(name = "prod_name", length = 100, unique = true)
	private String name;

	@Column(name = "descrip", length = 500)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "prod_category", length = 50)
	private Category category;

	@Column(name = "prod_price")
	private double price;

	@Column(name = "in_stock")
	private int stock;

	@Column(name = "expiry_date")
	private LocalDate exipryDate;

}
