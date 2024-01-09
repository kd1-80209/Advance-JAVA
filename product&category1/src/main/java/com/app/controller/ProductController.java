package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.service.ProductService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
@NoArgsConstructor
public class ProductController {

	@Autowired
	private ProductService prodService;

	@GetMapping
	public /* @RequestBody */ List<Product> listProd() {

		System.out.println("In Get Product List");

		return prodService.getAllProducts();
	}

	@PostMapping
	public Product addProduct(@org.springframework.web.bind.annotation.RequestBody Product prod) {
		System.out.println("In Add product" + prod);
		return prodService.productInDatabase(prod);
	}

}
