package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDTO;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductService prodService;

	public ProductController() {

		System.out.println("in Ctor of " + getClass());
	}

	@PostMapping("/category/{catId}")
	public ProductDTO addnewProduct(@RequestBody @Valid ProductDTO prodDto, @PathVariable Long catId) {

		System.out.println("in add new product" + prodDto + "in Category" + catId);

		return prodService.addproduct(prodDto, catId);
	}

}
