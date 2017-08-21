# Introduction
- Master JPA & Hibernate with Spring Boot - Preview
- Master JPA & Hibernate with Spring Boot - Course Overview
- Master JPA & Hibernate with Spring Boot - Git Repository
- Master JPA & Hibernate with Spring Boot - Installing Basic Tools

# JPA Introduction
- TODO - What is JPA?
   - A quick 5 minute introduction

# Spring Boot in 10 Steps
- TODO
- Step 0 : Spring Boot in 10 Steps - Section Introduction
- Step 1 : Introduction to Spring Boot - Goals and Important Features
- Step 2 : Developing Spring Applications before Spring Boot
- Step 3 : Using Spring Initializr to create a Spring Boot Application
- Step 4 : Creating a Simple REST Controller
- Step 5 : What is Spring Boot Auto Configuration?
- Step 6 : Spring Boot vs Spring vs Spring MVC
- Step 7 : Spring Boot Starter Projects - Starter Web and Starter JPA
- Step 8 : Overview of different Spring Boot Starter Projects
- Step 9 : Spring Boot Actuator
- Step 10 : Spring Boot Developer Tools

# Journey from JDBC To JPA
- TODO
- Step 01 - Setting up a project with JDBC, JPA, H2 and Web Dependencies
- Step 02 - Launching up H2 Console
- Step 03 - Creating a Database Table in H2
- Step 04 - Populate data into Person Table
- Step 05 - Implement findAll persons Spring JDBC Query Method
- Step 06 - Execute the findAll method using CommandLineRunner
- Step 07 - A Quick Review - JDBC vs Spring JDBC
- Step 08 - Whats in the background? Understanding Spring Boot Autoconfiguration
- Step 09 - Implementing findById Spring JDBC Query Method
- Step 10 - Implementing deleteById Spring JDBC Update Method
- Step 11 - Implementing insert and update Spring JDBC Update Methods
- Step 12 - Creating a custom Spring JDBC RowMapper
- Step 13 - Quick introduction to JPA
- Step 14 - Defining Person Entity
- Step 15 - Implementing findById JPA Repository Method
- Step 16 - Implementing insert and update JPA Repository Methods
- Step 17 - Implementing deleteById JPA Repository Method
- Step 18 - Implementing findAll using JPQL Named Query

# JUnit in 5 Steps
- TODO
- Step 1 : What is JUnit and Unit Testing?
- Step 2 : First JUnit Project and Green Bar
- Step 3 : First Code and First Unit Test
- Step 4 : Other assert methods
- Step 5 : Important annotations

# JPA/Hibernate in Depth


# Conclusion
- Master JPA & Hibernate with Spring Boot - Congratulations on Completing the Course

## Appendix - Spring Framework in 10 Steps
- Step 1 - Setting up a Spring Project using htttp://start.spring.io
- Step 2 - Understanding Tight Coupling using the Binary Search Algorithm Example
- Step 3 - Making the Binary Search Algorithm Example Loosely Coupled
- Step 4 - Using Spring to Manage Dependencies - @Component, @Autowired
- Step 5 - What is happening in the background?
- Step 6 - Dynamic auto wiring and Troubleshooting - @Primary
- Step 7 - Constructor and Setter Injection
- Step 8 - Spring Modules
- Step 9 - Spring Projects
- Step 10 - Why is Spring Popular?


## Notes
## Hibernate Mapping
<hibernate-mapping>
   <class name="Person" table="person">
      <id name="id" type="int" column="id">
         <generator class="native"/>
      </id>
      <property name="firstName" column="first_name" type="string"/>
      <property name="lastName" column="last_name" type="string"/>
      <property name="role" column="role " type="integer"/>
   </class>
</hibernate-mapping>

## JPQL

## Entity Manager
- detach method
- clear method
- flush method

## Play with Annotations
- @Table : Indicates table name.
- @Column : Defining Constraints on Columns
- @Transient : Column will not be persisted.
- @NamedQueries Indicates list of named queries.
- @NamedQuery Indicates a Query using static name.
```
@NamedQueries({
    @NamedQuery(name="name1",
                query="Query1"),
    @NamedQuery(name="name2",
                query="Query2"),
})
```
- @CreationTimestamp 
- @UpdateTimestamp

## Native Queries
- Database specific feature

## Relationships

## Inheritance
- best performance - single table strategy
- best data integrity - joined 

## Criteria API

## Transaction Management
- Transactions have importance even within read-only context - like specifying a database isolation-level. We strongly recommend that all database operations occur within the scope of some transaction.

## Performance Tuning
- Check Stats in atleast one environment
- Do not use JPA/Hibernate for Database intensive Batch Operations - Use Stored Procedures  
- Add the right indexes on the database - Execution Plan
- Use Appropriate Caching
- Eager vs Lazy Fetch - Use Lazy fetching mostly
  - Remember that all mapping *ToOne (@ManyToOne and @OneToOne) are EAGER by default.
- Avoid N+1
  - Entity Graph & Named Entity Graphs & Dynamic Entity Graphs
  - Join Fetch Clause
- Use Pagination

## Hibernate Tips
- @Where
- @SQLDelete
- @Immutable - zero dirty checks!
- Embedded
- Enumerations
- javax.persistence.CascadeType
- When do you use JPA? SQL Database + Static Domain Model + Mostly CRUD + Mostly Simple Queries/Mappings and Updates with few Stored Procedures

## Caching
- First Level Cache Demo
- Second Level Cache Demo

## Spring Data JPA
- Spring Data REST

## Complete Code Example

