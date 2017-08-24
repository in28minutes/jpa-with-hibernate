package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void insert(Employee employee) {
		em.persist(employee);
	}

	public List<Employee> retrieveAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
}