package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CategoryDTO;
import com.app.entities.Category;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository catRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDTO addCatInDatabase(CategoryDTO catDto) {

		Category catEntity = catRepo.save(mapper.map(catDto, Category.class));
		return mapper.map(catEntity, CategoryDTO.class);
	}

}
