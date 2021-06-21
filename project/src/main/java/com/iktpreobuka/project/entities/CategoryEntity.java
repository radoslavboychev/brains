package com.iktpreobuka.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryEntity {

	/**
	 * Zadatak 2 - 2.1 T3 - 1.3 Edited
	 */

	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "categoryName")
	private String categoryName;

	@Column(name = "categoryDescription")
	private String categoryDescription;

	// constructor
	public CategoryEntity(int id, String categoyName, String categoryDescription) {
		super();
		this.id = id;
		this.categoryName = categoyName;
		this.categoryDescription = categoryDescription;
	}

	//default constructor
	public CategoryEntity() {
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoyName() {
		return categoryName;
	}

	public void setCategoyName(String categoyName) {
		this.categoryName = categoyName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

}
