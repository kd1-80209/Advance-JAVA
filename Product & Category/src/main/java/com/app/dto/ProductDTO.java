package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotBlank
	@UniqueElements
	private String prodName;

	private String description;

//	@Range(max = 500)
	@Max(500)
	private double price;

	private int availStock;

	@Future
	private LocalDate expiryDate;

}
