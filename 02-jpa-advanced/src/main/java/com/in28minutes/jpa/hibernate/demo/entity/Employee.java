package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	protected Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return String.format("Employee[%s]", name);
	}
}