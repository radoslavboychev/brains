package com.iktpreobuka.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project.entities.CategoryEntity;

/**
 * 
 * Zadatak 2 - 2.2
 *
 */

@RestController

public class CategoryController {
	@RequestMapping("/project/categories")
	protected List<CategoryEntity> getDB() {
		List<CategoryEntity> categories = new ArrayList<>();

		CategoryEntity c1 = new CategoryEntity(1, "music", "description 1");
		CategoryEntity c2 = new CategoryEntity(2, "food", "description 2");
		CategoryEntity c3 = new CategoryEntity(3, "entertainment", "description 3");

		categories.add(c1);
		categories.add(c2);
		categories.add(c3);

		return categories;
	}

	/**
	 * 
	 * Zadatak 2 - 2.3
	 *
	 */
	@PostMapping("/project/categories")
	public CategoryEntity addCategory(@RequestBody CategoryEntity addedCategory) {

		System.out.println("Category" + addedCategory.getId() + " " + addedCategory.getCategoyName() + " "
				+ addedCategory.getCategoryDescription());
		
		System.out.println("Category added!\n");

		return addedCategory;
	}

}
