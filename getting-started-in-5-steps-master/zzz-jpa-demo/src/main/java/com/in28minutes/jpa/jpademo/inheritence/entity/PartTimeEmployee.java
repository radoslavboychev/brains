package com.in28minutes.jpa.jpademo.inheritence.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
	
	public PartTimeEmployee(){}
	
	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	protected BigDecimal hourlyWage;
}