package com.in28minutes.jpa.hibernate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}
