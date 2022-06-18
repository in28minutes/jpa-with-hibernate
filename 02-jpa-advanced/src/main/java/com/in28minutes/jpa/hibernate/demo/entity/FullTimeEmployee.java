package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;
// Change from javax to jakarta
import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {
	protected FullTimeEmployee() {
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	private BigDecimal salary;

}
