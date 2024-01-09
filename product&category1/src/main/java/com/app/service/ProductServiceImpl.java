package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepository;

	@Override
	public List<Product> getAllProducts() {

		return prodRepository.findAll();
	}

	@Override
	public Product productInDatabase(Product prod) {

		return prodRepository.save(prod);
	}

}
