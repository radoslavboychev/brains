package com.iktpreobuka.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iktpreobuka.project.entities.CategoryEntity;
import com.iktpreobuka.project.repositories.CategoryRepository;

@RestController
@RequestMapping("/api/v1/project/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	// post mapping
	// T2 2.4
	@RequestMapping(method = RequestMethod.POST)
	public CategoryEntity add(@RequestBody ObjectNode objectNode) {

		CategoryEntity newCategory = new CategoryEntity(objectNode.get("name").asText(),
				objectNode.get("description").asText());

		categoryRepository.save(newCategory);

		return newCategory;
	}

	// get mapping
	// T2 2.3
	@RequestMapping(method = RequestMethod.GET)
	public List<CategoryEntity> getAll() {
		return (List<CategoryEntity>) categoryRepository.findAll();
	}

	// T2 2.7
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public CategoryEntity getById(@PathVariable Integer id) {

		return categoryRepository.findById(id).orElse(null);
	}

	// put mapping
	// T2 2.5
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public CategoryEntity changeCategory(@PathVariable Integer id, @RequestBody ObjectNode objectNode) {

		CategoryEntity category = categoryRepository.findById(id).orElse(null);
		if (category == null)
			return null;

		String name = objectNode.get("name").asText();
		String description = objectNode.get("description").asText();

		if (name != null)
			category.setName(name);
		if (description != null)
			category.setDescription(description);

		categoryRepository.save(category);

		return category;
	}

	// delete mapping
	// T2 2.6
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public CategoryEntity delete(@PathVariable Integer id) {

		CategoryEntity category = categoryRepository.findById(id).orElse(null);
		if (category == null)
			return null;

		categoryRepository.delete(category);

		return category;
	}
}
