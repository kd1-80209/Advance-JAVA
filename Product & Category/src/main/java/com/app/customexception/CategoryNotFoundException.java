package com.app.customexception;

public class CategoryNotFoundException extends RuntimeException {

	public CategoryNotFoundException(String msg) {
		super(msg);
	}

}
