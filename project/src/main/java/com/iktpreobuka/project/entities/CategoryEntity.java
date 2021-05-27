package com.iktpreobuka.project.entities;

public class CategoryEntity {

	/**
	 * Zadatak 2 - 2.1
	 */

	//attributes
	private int id;
	private String categoyName;
	private String categoryDescription;
	
	
	
	//constructor
	public CategoryEntity(int id, String categoyName, String categoryDescription) {
		super();
		this.id = id;
		this.categoyName = categoyName;
		this.categoryDescription = categoryDescription;
	}
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoyName() {
		return categoyName;
	}
	public void setCategoyName(String categoyName) {
		this.categoyName = categoyName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	
}
