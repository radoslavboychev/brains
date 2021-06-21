package com.iktpreobuka.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project.entities.CategoryEntity;
import com.iktpreobuka.project.repositories.CategoryRepository;

/**
 * 
 * Zadatak 2 - 2.3 T3 - Zadatak 1 - 1.3
 */

@RestController
public class CategoryController {
	@RequestMapping("/project/categories")
	public Iterable<CategoryEntity> getDB() {

		return categoryRepository.findAll();

		// This is the old code from the previous week
//		List<CategoryEntity> categories = new ArrayList<>();
//
//		CategoryEntity c1 = new CategoryEntity(1, "music", "description 1");
//		CategoryEntity c2 = new CategoryEntity(2, "food", "description 2");
//		CategoryEntity c3 = new CategoryEntity(3, "entertainment", "description 3");
//
//		categories.add(c1);
//		categories.add(c2);
//		categories.add(c3);
//
//		return categories;
	}

	/**
	 * T3 - Zadatak 1.3
	 */
	@Autowired
	private CategoryRepository categoryRepository;

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

		// add it to the db list
		// T3 edited
		categoryRepository.save(addedCategory);

		return addedCategory;
	}

	/**
	 * Zadatak 2 - 2.5
	 */
	@PutMapping("/project/categories/{id}")
	public CategoryEntity editCategory(@PathVariable int id, @RequestBody CategoryEntity editedCategory) {
		for (CategoryEntity cat : getDB()) {
			if (cat.getId() == editedCategory.getId()) {
				cat.setId(editedCategory.getId());
				cat.setCategoyName(editedCategory.getCategoyName());
				cat.setCategoryDescription(editedCategory.getCategoryDescription());
				
				//T3 edited
				categoryRepository.save(editedCategory);
				return cat;
			}
		}

		return null;

	}

	/**
	 * Zadatak 2 - 2.6
	 */
	@DeleteMapping("/project/categories/{id}")
	public CategoryEntity deleteCategory(@PathVariable int id) {
		for (CategoryEntity cat : getDB()) {
			if (cat.getId() == id) {
				
				//T3 Edited
				categoryRepository.delete(cat);
				return cat;
			}
		}
		return null;
	}

	/**
	 * Zadatak 2 - 2.7
	 */
	@GetMapping("/project/categories/{id}")
	public CategoryEntity getCategoryByID(@PathVariable int id) {
		for (CategoryEntity cat : getDB()) {
			if (cat.getId() == id) {
				
				categoryRepository.save(cat);
				return cat;
			}
		}
		return null;
	}

}
