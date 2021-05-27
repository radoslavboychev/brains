package com.iktpreobuka.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project.entities.CategoryEntity;

/**
 * 
 * Zadatak 2 - 2.3
 *
 */

@RestController

public class CategoryController {
	@RequestMapping("/project/categories")
	public List<CategoryEntity> getDB() {
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
	 * Zadatak 2 - 2.4
	 *
	 */
	@PostMapping("/project/categories")
	public CategoryEntity addCategory(@RequestBody CategoryEntity addedCategory) {

		System.out.println("Category" + addedCategory.getId() + " " + addedCategory.getCategoyName() + " "
				+ addedCategory.getCategoryDescription());
		
		System.out.println("Category added!\n");
		
		//add it to the db list
		getDB().add(addedCategory);

		return addedCategory;
	}
	
	/**
	 * Zadatak 2 - 2.5 
	 */
	@PutMapping("/project/categories/{id}")
	public CategoryEntity editCategory(@PathVariable int id, @RequestBody CategoryEntity editedCategory)
	{
		for (CategoryEntity cat  : getDB()) {
			if(cat.getId() == editedCategory.getId())
			{
				cat.setId(editedCategory.getId());
				cat.setCategoyName(editedCategory.getCategoyName());
				cat.setCategoryDescription(editedCategory.getCategoryDescription());
				
				return cat;
			}
		}
		
		return null;
		
	}
	
	/**
	 * Zadatak 2 - 2.6
	 */
	@DeleteMapping("/project/categories/{id}")
	public CategoryEntity deleteCategory(@PathVariable int id)
	{
		for (CategoryEntity cat : getDB()) {
			if (cat.getId() == id) {
				getDB().remove(id);
				return cat;
			}
		}
		return null;
	}
	/**
	 * Zadatak 2 - 2.7
	 */
	@GetMapping("/project/categories/{id}")
	public CategoryEntity getCategoryByID(@PathVariable int id)
	{
		for (CategoryEntity cat : getDB()) {
			if(cat.getId() == id)
			{
				return cat;
			}
		}
		return null;
	}

}
