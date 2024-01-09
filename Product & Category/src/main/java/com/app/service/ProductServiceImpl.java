package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.CategoryNotFoundException;
import com.app.dto.ProductDTO;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.repository.CategoryRepository;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;

	@Autowired
	private CategoryRepository catRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ProductDTO addproduct(ProductDTO prodDto, Long catId) {

		Category catEntity = catRepo.findById(catId)
				.orElseThrow(() -> new CategoryNotFoundException("Category Not Avaliable !!!"));

		Product prodEntity = mapper.map(prodDto, Product.class);
		prodEntity.setCategory(catEntity);

		Product persistantProd = prodRepo.save(prodEntity);

		return mapper.map(persistantProd, ProductDTO.class);
	}

}
