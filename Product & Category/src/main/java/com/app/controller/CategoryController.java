package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CategoryDTO;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("http://localhost:3000")
public class CategoryController {

	@Autowired
	private CategoryService catService;

	public CategoryController() {
		System.out.println("in Ctor of " + getClass());
	}

	@PostMapping
	public CategoryDTO addcategory(@RequestBody CategoryDTO catDto) {

		System.out.println("In add category" + catDto);

		return catService.addCatInDatabase(catDto);
	}

}
