
## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.in28minutes.jpa.hibernate</groupId>
  <artifactId>app</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>app</name>
  <description>Demo project for Spring Boot</description>

  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.0.1</version>
    <relativePath /> <!-- lookup parent from repository -->
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
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <scope>runtime</scope>
    </dependency>
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-jpamodelgen</artifactId>
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
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
          <source>17</source>
          <target>17</target>
          <compilerArguments>
            <processor>org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor</processor>
          </compilerArguments>
        </configuration>
      </plugin>

      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>build-helper-maven-plugin</artifactId>
        <executions>
          <execution>
            <phase>process-sources</phase>
            <configuration>
              <sources>
                <source>${project.build.directory}/generated-sources/annotations</source>
              </sources>
            </configuration>
            <goals>
              <goal>add-source</goal>
            </goals>
          </execution>
        </executions>
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

### /src/main/java/com/in28minutes/jpa/hibernate/app/AppApplication.java

```java
package com.in28minutes.jpa.hibernate.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/app/entity/Course.java

```java
package com.in28minutes.jpa.hibernate.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Course {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String name;

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

  public Long getId() {
    return id;
  }

}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/app/entity/inheritance/Employee.java

```java
package com.in28minutes.jpa.hibernate.app.entity.inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "disc_type")
public abstract class Employee {

  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  @GeneratedValue
  @Id
  protected Integer id;

  private String name;

}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/app/entity/inheritance/FullTimeEmployee.java

```java
package com.in28minutes.jpa.hibernate.app.entity.inheritance;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {
  public FullTimeEmployee(){}
  
  public FullTimeEmployee(String name, BigDecimal salary) {
    super(name);
    this.salary = salary;
  }

  protected BigDecimal salary;
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/app/entity/inheritance/PartTimeEmployee.java

```java
package com.in28minutes.jpa.hibernate.app.entity.inheritance;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
  
  public PartTimeEmployee(){}
  
  public PartTimeEmployee(String name, BigDecimal hourlyWage) {
    super(name);
    this.hourlyWage = hourlyWage;
  }

  protected BigDecimal hourlyWage;
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/app/entity/Student.java

```java
package com.in28minutes.jpa.hibernate.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Student {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String name;

  private LocalDate birthDate;

  @CreationTimestamp
  private LocalDateTime createDateTime;

  @UpdateTimestamp
  private LocalDateTime updateDateTime;
    
  protected Student() {
  }

  public Student(String name, LocalDate birthDate) {
    this.name = name;
    this.birthDate = birthDate;
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

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/app/repository/CourseRepository.java

```java
package com.in28minutes.jpa.hibernate.app.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.app.entity.Course;

@Repository
@Transactional
public class CourseRepository {

  @Autowired
  private EntityManager entityManager;

  public Course findById(Long id) {
    return entityManager.find(Course.class, id);
  }

  public Course save(Course course) {
    if (course.getId() != null) {
      entityManager.merge(course);
    } else {
      entityManager.persist(course);
    }
    return course;
  }

  public void deleteById(Long id) {
    entityManager.remove(findById(id));
  }
}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/app/repository/EmployeeRepository.java

```java
package com.in28minutes.jpa.hibernate.app.repository;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.app.entity.inheritance.Employee;

@Transactional
@Repository
public class EmployeeRepository {
  
  @Autowired
  EntityManager entityManager;
  
  public void insertEmployee(Employee employee) {
    entityManager.persist(employee);
  }
  
  public List<Employee> allEmployees() {
    return entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
  }
  
  

}
```
---

### /src/main/java/com/in28minutes/jpa/hibernate/app/repository/StudentRepository.java

```java
package com.in28minutes.jpa.hibernate.app.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.app.entity.Student;

@Repository
@Transactional
public class StudentRepository {

  @Autowired
  private EntityManager entityManager;

  public Student findById(Long id) {
    return entityManager.find(Student.class, id);
  }

  public Student save(Student student) {
    if (student.getId() != null) {
      entityManager.merge(student);
    } else {
      entityManager.persist(student);
    }
    return student;
  }

  public void deleteById(Long id) {
    entityManager.remove(findById(id));
  }

  public void playWithStudent() {   
    Student student = new Student("Ranga", LocalDate.of(2000, Month.APRIL,10));
    entityManager.persist(student);
    entityManager.flush();
    // entityManager.remove(student);
    student.setName("Ranga-Changed");
    //entityManager.detach(student);
    entityManager.refresh(student);
    // entityManager.remove(student);
    // entityManager.merge(student);
    // Queries
    // Entity Graphs
  }
  
  public void transientFields() {   
    Student student = new Student("Ranga", LocalDate.of(2000, Month.APRIL,10));
    entityManager.persist(student);
    entityManager.flush();
    // entityManager.remove(student);
    student.setName("Ranga-Changed");
    //entityManager.detach(student);
    entityManager.refresh(student);
    // entityManager.remove(student);
    // entityManager.merge(student);
    // Queries
    // Entity Graphs
  }
}
```
---

### /src/main/resources/application.properties

```properties
spring.h2.console.enabled=true
spring.jpa.properties.hibernate.generate_statistics=true
logging.level.org.hibernate.stat=debug
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.data.jpa.repositories.bootstrap-mode=default
spring.jpa.defer-datasource-initialization=true
logging.level.org.hibernate.type=TRACE
```
---

### /src/main/resources/data.sql

```
insert into course(id, name) values(10001,'JPA in 100 Steps');
insert into course(id, name) values(10002,'Spring in 50 Steps');
insert into course(id, name) values(10003,'Spring Boot in 100 Steps');
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/app/AppApplicationTests.java

```java
package com.in28minutes.jpa.hibernate.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AppApplicationTests {

  @Test
  public void contextLoads() {
  }

}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/app/repository/CourseRepositoryCriterialQueryTest.java

```java
package com.in28minutes.jpa.hibernate.app.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.AppApplication;
import com.in28minutes.jpa.hibernate.app.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
public class CourseRepositoryCriterialQueryTest {

  @Autowired
  EntityManager entityManager;

  @Test
    public void basic() {

      CriteriaBuilder cb = entityManager.getCriteriaBuilder();

      CriteriaQuery<Course> cq = cb.createQuery(Course.class);
      Root<Course> root = cq.from(Course.class);

      TypedQuery<Course> query = entityManager.createQuery(cq.select(root));

      List<Course> courses = query.getResultList();
      System.out.println(courses);
    }

    @Test
    public void basic2() {
      CriteriaBuilder cb = entityManager.getCriteriaBuilder();
      CriteriaQuery<Course> cq = cb.createQuery(Course.class);

      Root<Course> course = cq.from(Course.class);
      Predicate condition = cb.like(course.get("name"), "%100 Steps");
      cq.where(condition);

      TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

      List<Course> courses = query.getResultList();
      System.out.println(courses);

      assertEquals(2, courses.size());
      System.out.println(courses);
    }

}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/app/repository/CourseRepositoryJPQLTest.java

```java
package com.in28minutes.jpa.hibernate.app.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.AppApplication;
import com.in28minutes.jpa.hibernate.app.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
public class CourseRepositoryJPQLTest {

  @Autowired
  EntityManager entityManager;

  @Test
  public void basic() {
    Query query = entityManager.createQuery("SELECT c FROM Course c");
    System.out.println(query.getResultList());
  }

  @Test
  public void basic_typed() {
    TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
    List<Course> resultList = query.getResultList();
    System.out.println(resultList);
  }

  @Test
  public void basic2() {
    Query query = entityManager.createQuery("SELECT c FROM Course c WHERE c.name like '%100 Steps'");
    List resultList = query.getResultList();
    assertEquals(2, resultList.size());
    System.out.println(resultList);
  }
}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/app/repository/CourseRepositoryTest.java

```java
package com.in28minutes.jpa.hibernate.app.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.AppApplication;
import com.in28minutes.jpa.hibernate.app.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AppApplication.class)
public class CourseRepositoryTest {
  
  @Autowired
  private CourseRepository repository;
  
  @Test
  public void findById(){
    assertNotNull(repository.findById(10001L));
    assertNull(repository.findById(10004L));
  }
  
  @Test
  public void deleteById(){
    repository.deleteById(10001L);
    assertNull(repository.findById(10001L));
  }
  
  @Test
  public void save(){
    Course course = repository.findById(10001L);
    course.setName("Name Changed");
    repository.save(course);
    Course courseUpdated = repository.findById(10001L);
    assertEquals("Name Changed",courseUpdated.getName());
  }

}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/app/repository/InheritanceDemoApplicationTest.java

```java
package com.in28minutes.jpa.hibernate.app.repository;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.entity.inheritance.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.app.entity.inheritance.PartTimeEmployee;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class InheritanceDemoApplicationTest {

  // @LocalServerPort
  // String port;

  @Autowired
  EntityManager entityManager;

  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  public void basic() {
    employeeRepository.insertEmployee(new PartTimeEmployee("PartTimeEE", new BigDecimal(100)));
    employeeRepository.insertEmployee(new FullTimeEmployee("FullTimeEE", new BigDecimal(10)));
    System.out.println(employeeRepository.allEmployees());
  }
}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/app/repository/StudentRepositoryTest.java

```java
package com.in28minutes.jpa.hibernate.app.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.app.AppApplication;
import com.in28minutes.jpa.hibernate.app.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AppApplication.class)
public class StudentRepositoryTest {
  
  @Autowired
  private StudentRepository repository;
  
  @Test
  public void playWithStudent(){
    repository.playWithStudent();
  }

}
```
---

### /src/test/java/com/in28minutes/jpa/hibernate/app/repository/TransactionManagementRepository.java

```java
package com.in28minutes.jpa.hibernate.app.repository;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.jpademo.relationships.entity.Passport;

@Repository
@Transactional
public class TransactionManagementRepository {

  @Autowired
  EntityManager entityManager;

  public void doSomething() {
    Passport passport1 = new Passport("E123456");
    entityManager.persist(passport1);
    Passport passport2 = new Passport(null);
    entityManager.persist(passport2);
  }
}
```
---
