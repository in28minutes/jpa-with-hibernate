/* Replace H2 sysdate() function(deprecated) with CURRENT_DATE() function */
insert into course(id, name, created_date, last_updated_date,is_deleted)
values(10001,'JPA in 50 Steps', CURRENT_DATE(), CURRENT_DATE(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted) 
values(10002,'Spring in 50 Steps', CURRENT_DATE(), CURRENT_DATE(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted) 
values(10003,'Spring Boot in 100 Steps', CURRENT_DATE(), CURRENT_DATE(),false);


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