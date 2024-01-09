package com.app.service;

import com.app.dto.ProductDTO;

public interface ProductService {

	ProductDTO addproduct(ProductDTO prodDto, Long catId);

}
