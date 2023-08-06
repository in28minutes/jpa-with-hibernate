##  JPA & Hibernate in Depth

Master JPA using Hibernate as the implementation. Learn the basics of JPA - entities, relationships, entity manager, annotations, JPQL and Criteria API. Take a step into the advanced world of JPA - caching, performance tuning(n + 1 queries), mapping inheritance hierarchies. Get a peek into the magic of Spring Data JPA & Spring Data Rest.


- Step 01 - Create a JPA Project with H2 and Spring Boot
- Step 02 - Create JPA Entity Course
- Step 03 - Create findById using JPA Entity Manager
- Step 04 - Configuring application.properties to enable H2 console and additional logging
- Step 05 - Writing Unit Test for findById method
- Step 06 - Writing a deleteByID method to delete an Entity
- Step 07 - Writing Unit Test for deleteById method
- Step 08 - Writing a save method to update and insert an Entity
- Step 09 - Writing Unit Test for save method
- Step 10 - Quick Review and Debugging Tips
- Step 11 - Playing with Entity Manager
- Step 12 - Entity Manager Methods - clear and detach
- Step 13 - Entity Manager Methods - refresh
- Step 14 - A Quick Review of Entity Manager
- Step 15 - JPQL - Basics
- Step 16 - JPA and Hibernate Annotations - @Table
- Step 17 - JPA and Hibernate Annotations - @Column
- Step 18 - JPA and Hibernate Annotations - @UpdateTimestamp and @CreationTimestamp
- Step 19 - JPA and Hibernate Annotations - @NamedQuery and @NamedQueries
- Step 20 - Native Queries - Basics
- Step 21 - Entities and Relationships - An overview
- Step 22 - Defining Entities - Student, Passport and Review
- Step 23 - Introduction to One to One Relationship
- Step 24 - OneToOne Mapping - Insert Student with Passport
- Step 25 - OneToOne Mapping - Retrieving Student with Passport and Eager Fetch
- Step 26 - OneToOne Mapping - Lazy Fetch
- Step 27 - Session vs Transaction
- Step 28 - OneToOne Mapping - Bidirectional Relationship - Part 1
- Step 29 - OneToOne Mapping - Bidirectional Relationship - Part 2
- Step 30 - ManyToOne Mapping - Designing the database
- Step 31 - ManyToOne Mapping - Retrieving and inserting Reviews for Course
- Step 32 - ManyToOne Mapping - Generalizing Insert Reviews
- Step 33 - ManyToOne Mapping - Wrapping up
- Step 34 - ManyToMany Mapping - Table Design
- Step 35 - ManyToMany Mapping - Adding Annotations on Entities
- Step 36 - ManyToMany Mapping - Fixing two join tables problem
- Step 37 - ManyToMany Mapping - Customizing the Join Table
- Step 38 - ManyToMany Mapping - Insert Data and Write Join Query
- Step 39 - ManyToMany Mapping - Retrieve Data using JPA Relationships
- Step 40 - ManyToMany Mapping - Insert Student and Course
- Step 41 - Relationships between JPA Entities - A summary
- Step 42 - Introduction to Inheritance Hierarchies and Mappings
- Step 43 - JPA Inheritance Hierarchies and Mappings - Setting up entities
- Step 44 - JPA Inheritance Hierarchies and Mappings - Setting up a Repository
- Step 45 - JPA Inheritance Hierarchies and Mappings - Single Table
- Step 46 - JPA Inheritance Hierarchies and Mappings - Table Per Class
- Step 47 - JPA Inheritance Hierarchies and Mappings - Joined
- Step 48 - JPA Inheritance Hierarchies and Mappings - Mapped Super Class
- Step 49 - JPA Inheritance Hierarchies and Mappings - How to Choose?
- Step 50 - JPQL - Courses without Students
- Step 51 - JPQL - Courses with atleast 2 Students and order by
- Step 52 - JPQL - Courses like 100 Steps
- Step 53 - JPQL - Using Joins
- Step 54 - Criteria Query - Retrieving all courses
- Step 55 - Criteria Query - Courses like 100 Steps
- Step 56 - Criteria Query - Courses without Students
- Step 57 - Criteria Query - Using Joins
- Step 58 - Introduction to Transaction Management
- Step 59 - Transaction Management - ACID Properties
- Step 60 - Understanding Dirty, Phanthom and Non Repeatable Reads
- Step 61 - Understand 4 Isolation Levels
- Step 62 - Choosing between Isolation Levels
- Step 63 - Implementing Transaction Management - 3 Things to Decide
- Step 64 - Introduction to Spring Data JPA
- Step 65 - Testing the Spring Data JPA Repository with findById.
- Step 66 - Spring Data JPA Repository - CRUD Methosd
- Step 67 - Sorting using Spring Data JPA Repository
- Step 68 - Pagination using Spring Data JPA Repository 
- Step 69 - Custom Queries using Spring Data JPA Repository 
- Step 70 - Spring Data REST
- Step 71 - Introduction to Caching
- Step 72 - Hibernate and JPA Caching - First Level Cache
- Step 73 - Hibernate and JPA Caching - Basics of Second Level Cache with EhCache
- Step 74 - Hibernate and JPA Caching - Second Level Cache Part 2
- Step 75 - Hibernate Tips - Hibernate Soft Deletes - @SQLDelete and @Where
- Step 76 - Hibernate Soft Deletes - Part 2
- Step 77 - JPA Entity Life Cycle Methods
- Step 78 - Using Embedded and Embeddable with JPA
- Step 79 - Using Enums with JPA
- Step 80 - JPA Tip - Be cautious with toString method implementations
- Step 81 - JPA Tip - When do you use JPA?
- Step 82 - Performance Tuning - Measure before Tuning
- Step 83 - Performance Tuning - Indexes
- Step 84 - Performance Tuning - Use Appropriate Caching
- Step 85 - Performance Tuning - Eager vs Lazy Fetch
- Step 86 - Performance Tuning - Avoid N+1 Problems


## Notes



## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.jpa.hibernate</groupId>
	<artifactId>demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>demo</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>17</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>
		<!-- extra for 2nd level cache https://northcoder.com/post/setting-up-hibernate-with-jcache-an/ -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-jcache</artifactId>
            <version>${hibernate-jcache.version}</version>
        </dependency>
        <dependency>
            <groupId>org.ehcache</groupId>
            <artifactId>ehcache</artifactId>
            <version>${ehcache.version}</version>
        </dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

	<repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

    <pluginRepositories>
        <pluginRepository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </pluginRepository>
    </pluginRepositories>


</project>
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/DemoApplication.java

```java
package com.in28minutes.jpa.hibernate.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// studentRepository.saveStudentWithPassport();
		// repository.playWithEntityManager();
		// courseRepository.addHardcodedReviewsForCourse();
		// List<Review> reviews = new ArrayList<>();

		// reviews.add(new Review("5", "Great Hands-on Stuff."));
		// reviews.add(new Review("5", "Hatsoff."));

		// courseRepository.addReviewsForCourse(10003L, reviews );
		// studentRepository.insertHardcodedStudentAndCourse();
		// studentRepository.insertStudentAndCourse(new Student("Jack"),
		// new Course("Microservices in 100 Steps"));

		// Jack FullTimeEmployee salary - 10000$
		// Jill PartTimeEmployee - 50$ per hour
		/*
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("Full Time Employees -> {}", 
				employeeRepository.retrieveAllFullTimeEmployees());
		
		logger.info("Part Time Employees -> {}", 
				employeeRepository.retrieveAllPartTimeEmployees());*/
	}
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/entity/Address.java

```java
package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	protected Address() {}
	
	public Address(String line1, String line2, String city) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
	}

	private String line1;
	private String line2;
	private String city;

	
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/entity/Course.java

```java
package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name = "query_get_all_courses", 
				query = "Select  c  From Course c"),		
		@NamedQuery(name = "query_get_all_courses_join_fetch", 
		query = "Select  c  From Course c JOIN FETCH c.students s"),		
		@NamedQuery(name = "query_get_100_Step_courses", 
		query = "Select  c  From Course c where name like '%100 Steps'") })
@Cacheable
@SQLDelete(sql="update course set is_deleted=true where id=?")
@Where(clause="is_deleted = false")
public class Course {

	private static Logger LOGGER = LoggerFactory.getLogger(Course.class);
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy="course")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	private boolean isDeleted;
	
	@PreRemove
	private void preRemove(){
		LOGGER.info("Setting isDeleted to True");
		this.isDeleted = true;
	}

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/entity/Employee.java

```java
package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Employee[%s]", name);
	}
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/entity/FullTimeEmployee.java

```java
package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

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
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/entity/PartTimeEmployee.java

```java
package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	protected PartTimeEmployee() {
	}

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	private BigDecimal hourlyWage;

}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/entity/Passport.java

```java
package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;

	protected Passport() {
	}

	public Passport(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Passport[%s]", number);
	}
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/entity/Review.java

```java
package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private ReviewRating rating;

	private String description;

	@ManyToOne
	private Course course;

	protected Review() {
	}

	public Review(ReviewRating rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating, description);
	}

}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/entity/ReviewRating.java

```java
package com.in28minutes.jpa.hibernate.demo.entity;

public enum ReviewRating {
	ZERO, ONE, TWO, THREE, FOUR, FIVE
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/entity/Student.java

```java
package com.in28minutes.jpa.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Embedded
	private Address address;

	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;

	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses = new ArrayList<>();

	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/repository/CourseRepository.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import jakarta.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.ReviewRating;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		Course course = em.find(Course.class, id);
		logger.info("Course -> {}", course);
		return course;
	}

	public Course save(Course course) {

		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}

		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}

	public void playWithEntityManager() {
		Course course1 = new Course("Web Services in 100 Steps");
		em.persist(course1);
		
		Course course2 = findById(10001L);
		
		course2.setName("JPA in 50 Steps - Updated");
		
	}

	public void addHardcodedReviewsForCourse() {
		//get the course 10003
		Course course = findById(10003L);
		logger.info("course.getReviews() -> {}", course.getReviews());
		
		//add 2 reviews to it
		Review review1 = new Review(ReviewRating.FIVE, "Great Hands-on Stuff.");	
		Review review2 = new Review(ReviewRating.FIVE, "Hatsoff.");
		
		//setting the relationship
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		//save it to the database
		em.persist(review1);
		em.persist(review2);
	}
	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {		
		Course course = findById(courseId);
		logger.info("course.getReviews() -> {}", course.getReviews());
		for(Review review:reviews)
		{			
			//setting the relationship
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
	}
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/repository/CourseSpringDataRepository.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
	List<Course> findByNameAndId(String name, Long id);

	List<Course> findByName(String name);

	List<Course> countByName(String name);

	List<Course> findByNameOrderByIdDesc(String name);

	List<Course> deleteByName(String name);

	@Query("Select  c  From Course c where name like '%100 Steps'")
	List<Course> courseWith100StepsInName();

	@Query(value = "Select  *  From Course c where name like '%100 Steps'", nativeQuery = true)
	List<Course> courseWith100StepsInNameUsingNativeQuery();

	@Query(name = "query_get_100_Step_courses")
	List<Course> courseWith100StepsInNameUsingNamedQuery();
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/repository/EmployeeRepository.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import jakarta.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void insert(Employee employee) {
		em.persist(employee);
	}

	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/demo/repository/StudentRepository.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import jakarta.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {

		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}

		return student;
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		em.persist(passport);

		Student student = new Student("Mike");

		student.setPassport(passport);
		em.persist(student);	
	}
	
	public void someOperationToUnderstandPersistenceContext() {
		//Database Operation 1 - Retrieve student
		Student student = em.find(Student.class, 20001L);
		//Persistence Context (student)
		
		
		//Database Operation 2 - Retrieve passport
		Passport passport = student.getPassport();
		//Persistence Context (student, passport)

		//Database Operation 3 - update passport
		passport.setNumber("E123457");
		//Persistence Context (student, passport++)
		
		//Database Operation 4 - update student
		student.setName("Ranga - updated");
		//Persistence Context (student++ , passport++)
	}
	
	public void insertHardcodedStudentAndCourse(){
		Student student = new Student("Jack");
		Course course = new Course("Microservices in 100 Steps");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		em.persist(student);
	}

	public void insertStudentAndCourse(Student student, Course course){
		//Student student = new Student("Jack");
		//Course course = new Course("Microservices in 100 Steps");
		student.addCourse(course);
		course.addStudent(student);

		em.persist(student);
		em.persist(course);
	}

}
```
---

### /src/main/resources/application.properties

```properties
# Enabling H2 Console
spring.h2.console.enabled=true

#Turn Statistics on
spring.jpa.properties.hibernate.generate_statistics=true
logging.level.org.hibernate.stat=debug

# Show all queries
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.type=trace
spring.jpa.properties.hibernate.connection.isolation=2

# Performance
spring.jpa.properties.hibernate.jdbc.batch_size=10

# Second Level Cache - Ehcache

#1. enable second level cache
spring.jpa.properties.hibernate.cache.use_second_level_cache=true

#2. specify the caching framework - EhCache
spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory

#3. Only cache what I tell to cache.
spring.jpa.properties.jakarta.persistence.sharedCache.mode=ENABLE_SELECTIVE

logging.level.net.sf.ehcache=debug

#4. What data to cache?
```
---

### /src/main/resources/data.sql

```
insert into course(id, name, created_date, last_updated_date,is_deleted) 
values(10001,'JPA in 50 Steps', sysdate(), sysdate(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted) 
values(10002,'Spring in 50 Steps', sysdate(), sysdate(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted) 
values(10003,'Spring Boot in 100 Steps', sysdate(), sysdate(),false);


insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);

insert into review(id,rating,description,course_id)
values(50001,'FIVE', 'Great Course',10001);
insert into review(id,rating,description,course_id)
values(50002,'FOUR', 'Wonderful Course',10001);
insert into review(id,rating,description,course_id)
values(50003,'FIVE', 'Awesome Course',10003);

insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10003);
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/demo/DemoApplicationTests.java

```java
package com.in28minutes.jpa.hibernate.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/demo/repository/CourseRepositoryTest.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Subgraph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager em;

	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
	}
	
	@Test
	public void findById_firstLevelCacheDemo() {
		
		Course course = repository.findById(10001L);
		logger.info("First Course Retrieved {}", course);

		Course course1 = repository.findById(10001L);
		logger.info("First Course Retrieved again {}", course1);

		assertEquals("JPA in 50 Steps", course.getName());
		
		assertEquals("JPA in 50 Steps", course1.getName());
	}


	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		// get a course
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());

		// update details
		course.setName("JPA in 50 Steps - Updated");
		repository.save(course);

		// check the value
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}

	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = repository.findById(10001L);
		logger.info("{}", course.getReviews());
	}

	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 50001L);
		logger.info("{}", review.getCourse());
	}

	@Test
	@Transactional
	@DirtiesContext
	public void performance() {
		//for (int i = 0; i < 20; i++)
			//em.persist(new Course("Something" + i));
		//em.flush();
		
		//EntityGraph graph = em.getEntityGraph("graph.CourseAndStudents");
		
		EntityGraph<Course> graph = em.createEntityGraph(Course.class);
	    Subgraph<List<Student>> bookSubGraph = graph.addSubgraph("students");
	    
	    List<Course> courses = em.createQuery("Select c from Course c", Course.class)
	        .setHint("jakarta.persistence.loadgraph", graph)
	        .getResultList();
	    for (Course course : courses) {
	      System.out.println(course + " " + course.getStudents());
	    }
	}

	@Test
	@Transactional
	@DirtiesContext
	public void performance_without_hint() {	    
	    List<Course> courses = em.createQuery("Select c from Course c", Course.class)
	        //.setHint("jakarta.persistence.loadgraph", graph)
	        .getResultList();
	    for (Course course : courses) {
	      System.out.println(course + " " + course.getStudents());
	    }
	}

}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/demo/repository/CourseSpringDataRepositoryTest.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository repository;

	@Test
	public void findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		assertTrue(courseOptional.isPresent());
	}

	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001L);
		assertFalse(courseOptional.isPresent());
	}

	@Test
	public void playingAroundWithSpringDataRepository() {
		//Course course = new Course("Microservices in 100 Steps");
		//repository.save(course);

		//course.setName("Microservices in 100 Steps - Updated");
		//repository.save(course);
		logger.info("Courses -> {} ", repository.findAll());
		logger.info("Count -> {} ", repository.count());
	}

	@Test
	public void sort() {
		Sort sort = new Sort(Sort.Direction.ASC, "name");
		logger.info("Sorted Courses -> {} ", repository.findAll(sort));
		//Courses -> [Course[JPA in 50 Steps], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]] 
	}

	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("First Page -> {} ", firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = repository.findAll(secondPageable);
		logger.info("Second Page -> {} ", secondPage.getContent());
	}
	
	@Test
	public void findUsingName() {
		logger.info("FindByName -> {} ", repository.findByName("JPA in 50 Steps"));
	}

	@Test
	public void findUsingStudentsName() {
		logger.info("findUsingStudentsName -> {} ", repository.findByName("Ranga"));
	}

}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/demo/repository/CriteriaQueryTest.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class CriteriaQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void all_courses() {
		// "Select c From Course c"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder

		// 4. Add Predicates etc to the Criteria Query

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();

		logger.info("Typed Query -> {}", resultList);
		// [Course[JPA in 50 Steps], Course[Spring in 50 Steps], Course[Spring
		// Boot in 100 Steps]]
	}

	@Test
	public void all_courses_having_100Steps() {
		// "Select c From Course c where name like '%100 Steps' "

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");

		// 4. Add Predicates etc to the Criteria Query
		cq.where(like100Steps);

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();

		logger.info("Typed Query -> {}", resultList);
		// [Course[Spring Boot in 100 Steps]]
	}

	@Test
	public void all_courses_without_students() {
		// "Select c From Course c where c.students is empty"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));

		// 4. Add Predicates etc to the Criteria Query
		cq.where(studentsIsEmpty);

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();

		logger.info("Typed Query -> {}", resultList);
		// [Course[Spring in 50 Steps]]
	}

	@Test
	public void join() {
		// "Select c From Course c join c.students s"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students");

		// 4. Add Predicates etc to the Criteria Query

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();

		logger.info("Typed Query -> {}", resultList);
		// [Course[JPA in 50 Steps], Course[JPA in 50 Steps], Course[JPA in 50
		// Steps], Course[Spring Boot in 100 Steps]]
	}

	@Test
	public void left_join() {
		// "Select c From Course c left join c.students s"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

		// 4. Add Predicates etc to the Criteria Query

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();

		logger.info("Typed Query -> {}", resultList);
		// [Course[JPA in 50 Steps], Course[JPA in 50 Steps], Course[JPA in 50
		// Steps], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]]
	}

}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/demo/repository/JPQLTest.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void jpql_basic() {
		Query query = em.createNamedQuery("query_get_all_courses");
		List resultList = query.getResultList();
		logger.info("Select  c  From Course c -> {}", resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);

		List<Course> resultList = query.getResultList();

		logger.info("Select  c  From Course c -> {}", resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_100_Step_courses", Course.class);

		List<Course> resultList = query.getResultList();

		logger.info("Select  c  From Course c where name like '%100 Steps'-> {}", resultList);
		// [Course[Web Services in 100 Steps], Course[Spring Boot in 100 Steps]]
	}

	@Test
	public void jpql_courses_without_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
		// [Course[Spring in 50 Steps]]
	}

	
	@Test
	public void jpql_courses_with_atleast_2_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
		//[Course[JPA in 50 Steps]]
	}

	@Test
	public void jpql_courses_ordered_by_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
	}

	@Test
	public void jpql_students_with_passports_in_a_certain_pattern() {
		TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
		List<Student> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
	}

	//like
	//BETWEEN 100 and 1000
	//IS NULL
	//upper, lower, trim, length
	
	//JOIN => Select c, s from Course c JOIN c.students s
	//LEFT JOIN => Select c, s from Course c LEFT JOIN c.students s
	//CROSS JOIN => Select c, s from Course c, Student s
	//3 and 4 =>3 * 4 = 12 Rows
	@Test
	public void join(){
		Query query = em.createQuery("Select c, s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results Size -> {}", resultList.size());
		for(Object[] result:resultList){
			logger.info("Course{} Student{}", result[0], result[1]);
		}
	}

	@Test
	public void left_join(){
		Query query = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results Size -> {}", resultList.size());
		for(Object[] result:resultList){
			logger.info("Course{} Student{}", result[0], result[1]);
		}
	}

	@Test
	public void cross_join(){
		Query query = em.createQuery("Select c, s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results Size -> {}", resultList.size());
		for(Object[] result:resultList){
			logger.info("Course{} Student{}", result[0], result[1]);
		}
	}

}








```
---

### /src/test/java/com/in28minutes/jpa/hibernate/demo/repository/NativeQueriesTest.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void native_queries_basic() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM COURSE  -> {}", resultList);
		//SELECT * FROM COURSE  -> [Course[Web Services in 100 Steps], Course[JPA in 50 Steps - Updated], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]]
	}

	@Test
	public void native_queries_with_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM COURSE  where id = ? -> {}", resultList);
		//[Course[JPA in 50 Steps - Updated]]
	}

	@Test
	public void native_queries_with_named_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM COURSE  where id = :id -> {}", resultList);
		//[Course[JPA in 50 Steps - Updated]]
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("Update COURSE set last_updated_date=sysdate()");
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("noOfRowsUpdated  -> {}", noOfRowsUpdated);
		//SELECT * FROM COURSE  -> [Course[Web Services in 100 Steps], Course[JPA in 50 Steps - Updated], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]]
	}


}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/demo/repository/PerformanceTuningTest.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Subgraph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class PerformanceTuningTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void creatingNPlusOneProblem() {
		List<Course> courses = em
				.createNamedQuery("query_get_all_courses", Course.class)
				.getResultList();
		for(Course course:courses){
			logger.info("Course -> {} Students -> {}",course, course.getStudents());
		}
	}
	
	@Test
	@Transactional
	public void solvingNPlusOneProblem_EntityGraph() {

		EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
		Subgraph<Object> subGraph = entityGraph.addSubgraph("students");
		
		List<Course> courses = em
				.createNamedQuery("query_get_all_courses", Course.class)
				.setHint("jakarta.persistence.loadgraph", entityGraph)
				.getResultList();
		
		for(Course course:courses){
			logger.info("Course -> {} Students -> {}",course, course.getStudents());
		}
	}

	@Test
	@Transactional
	public void solvingNPlusOneProblem_JoinFetch() {
		List<Course> courses = em
				.createNamedQuery("query_get_all_courses_join_fetch", Course.class)
				.getResultList();
		for(Course course:courses){
			logger.info("Course -> {} Students -> {}",course, course.getStudents());
		}
	}

}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/demo/repository/StudentRepositoryTest.java

```java
package com.in28minutes.jpa.hibernate.demo.repository;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Address;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	// Session & Session Factory

	// EntityManager & Persistence Context
	// Transaction

	@Test
	public void someTest() {
		repository.someOperationToUnderstandPersistenceContext();
	}

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}

	@Test
	@Transactional
	public void setAddressDetails() {
		Student student = em.find(Student.class, 20001L);
		student.setAddress(new Address("No 101", "Some Street", "Hyderabad"));
		em.flush();
	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		
		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}

}
```
---
