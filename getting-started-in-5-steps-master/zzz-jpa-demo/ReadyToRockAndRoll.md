
## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.jpa</groupId>
	<artifactId>jpa-demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>jpa-demo</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.M3</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
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
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-ehcache</artifactId>
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
					<source>1.8</source>
					<target>1.8</target>
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
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
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
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>maven-annotation</id>
			<url>http://maven-annotation-plugin.googlecode.com/svn/trunk/mavenrepo</url>
		</pluginRepository>
	</pluginRepositories>


</project>
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/controller/CourseController.java

```java
package com.in28minutes.jpa.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository repository;
	
	@GetMapping("/courses/{id}")
	public  Course retrieveCourse(@PathVariable long id){
		return repository.retrieveCourse(id);
	}
}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/embedded/entity/Name.java

```java
package com.in28minutes.jpa.jpademo.embedded.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Embeddable
public class Name {
	
	@Id
	@GeneratedValue
	protected Long id;
	protected String firstName;
	protected String middleName;
	protected String lastName;
}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/embedded/entity/Person.java

```java

package com.in28minutes.jpa.jpademo.embedded.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue
	protected Long id;
	
	@OneToOne
	//@Embedded
	protected Name name;

}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/inheritence/entity/Employee.java

```java
package com.in28minutes.jpa.jpademo.inheritence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

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

### /src/main/java/com/in28minutes/jpa/jpademo/inheritence/entity/FullTimeEmployee.java

```java
package com.in28minutes.jpa.jpademo.inheritence.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

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

### /src/main/java/com/in28minutes/jpa/jpademo/inheritence/entity/PartTimeEmployee.java

```java
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
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/inheritence/repository/EmployeeRepository.java

```java
package com.in28minutes.jpa.jpademo.inheritence.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.jpademo.inheritence.entity.Employee;

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

### /src/main/java/com/in28minutes/jpa/jpademo/JpaDemoApplication.java

```java
package com.in28minutes.jpa.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.jpademo.inheritence.repository.EmployeeRepository;
import com.in28minutes.jpa.jpademo.relationships.repository.StudentRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired 
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/entity/Course.java

```java
package com.in28minutes.jpa.jpademo.relationships.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Course")
@NamedQuery(query = "select c from Course c", name = "QUERY_ALL_COURSES")
@NamedEntityGraph(name = "graph.CourseAndStudents", 
attributeNodes = @NamedAttributeNode(value = "students"/*, subgraph = "students"),*/)
/*subgraphs = @NamedSubgraph(name = "students", attributeNodes = @NamedAttributeNode("passport"))*/)
@Cacheable
public class Course {

	public Course() {
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue
	protected Long id;

	protected String name;

	// @OneToMany
	@OneToMany(mappedBy = "course")
	protected List<Review> reviews = new ArrayList<>();

	@ManyToMany
	// @JoinTable(name = "COURSE_STUDENT",
	// joinColumns = @JoinColumn(name = "COURSE_ID"),
	// inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
	protected List<Student> students = new ArrayList<>();

	@CreationTimestamp
	private LocalDateTime createDateTime;

	private LocalDate activeFrom;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Long getId() {
		return id;
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

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public LocalDate getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(LocalDate activeFrom) {
		this.activeFrom = activeFrom;
	}

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}

}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/entity/Passport.java

```java
package com.in28minutes.jpa.jpademo.relationships.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "1=1")
public class Passport {

	protected Passport() {
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	@Id
	@GeneratedValue
	protected Long id;

	@NotNull
	protected String number;

	// Inverse Relationship
	// bi-directional OneToOne relationship
	// Column will not be created in the table
	// Try removing mappedBy = "passport" => You will see a student_id column
	// will be created in passport
	// @OneToOne
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	protected Student student;

	public Long getId() {
		return id;
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
}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/entity/Review.java

```java
package com.in28minutes.jpa.jpademo.relationships.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	private Review() {}

	public Review(ReviewRating rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	@Id
	@GeneratedValue
	protected Long id;
	
	@Enumerated
	protected ReviewRating rating;
		
	protected String description;

	@ManyToOne
	// @JoinColumn(name="COURSE_ID")
	protected Course course;

	public Long getId() {
		return id;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/entity/ReviewRating.java

```java
package com.in28minutes.jpa.jpademo.relationships.entity;
public enum ReviewRating {
	ONE,TWO,THREE,FOUR,FIVE
}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/entity/Student.java

```java
package com.in28minutes.jpa.jpademo.relationships.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToOne;

import org.hibernate.annotations.SQLDelete;

@Entity
@SQLDelete(sql = "UPDATE student SET state = 'DELETED' WHERE id = ?")
public class Student {

	private Student() {
	}

	public Student(String name, StudentType studentType) {
		super();
		this.name = name;
		this.studentType = studentType;
	}

	@Id
	@GeneratedValue
	protected Long id;

	protected String name;

	@OneToOne(fetch = FetchType.LAZY)
	protected Passport passport;

	// @ManyToMany
	@ManyToMany(mappedBy = "students")
	protected List<Course> courses = new ArrayList<>();

	// @Enumerated
	@Enumerated(EnumType.STRING)
	private StudentType studentType;

	@ElementCollection
	@CollectionTable(name = "STUDENT_PHONE")
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "PHONE_TYPE")
	@Column(name = "PHONE_NUM")
	private Map<PhoneType, String> phoneNumbers;

	enum PhoneType {
		Home, Mobile, Work
	}

	public Long getId() {
		return id;
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
		courses.add(course);
	}

	public StudentType getStudentType() {
		return studentType;
	}

	public void setStudentType(StudentType studentType) {
		this.studentType = studentType;
	}

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void addPhoneNumber(PhoneType phoneType, String number) {
		phoneNumbers.put(phoneType, number);
	}

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}

}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/entity/StudentType.java

```java
package com.in28minutes.jpa.jpademo.relationships.entity;
public enum StudentType {
	FullTime, PartTime
}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/repository/CourseRepository.java

```java
package com.in28minutes.jpa.jpademo.relationships.repository;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Course_;
import com.in28minutes.jpa.jpademo.relationships.entity.Review;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager entityManager;

	public void createCourse(Course course) {
		entityManager.persist(course);
	}

	public Course retrieveCourse(Long id) {
		return entityManager.find(Course.class, id);
	}

	public void printAllCourseAndStudents() {
		EntityGraph graph = entityManager.getEntityGraph("graph.CourseAndStudents");
		List<Course> courses = entityManager.createQuery("Select c from Course c", Course.class)
				.setHint("javax.persistence.loadgraph", graph).getResultList();
		for (Course course : courses) {
			System.out.println(course + " " + course.getStudents());
		}
	}

	public void printAllCourseAndStudentsDynamicSubgraph() {
		EntityGraph<Course> graph = entityManager.createEntityGraph(Course.class);
		Subgraph<List<Student>> bookSubGraph = graph.addSubgraph(Course_.students);

		List<Course> courses = entityManager.createQuery("Select c from Course c", Course.class)
				.setHint("javax.persistence.loadgraph", graph).getResultList();

		for (Course course : courses) {
			System.out.println(course + " " + course.getStudents());
		}
	}

	public void printAllCourseAndStudentsJoinFetch() {
		List<Course> courses = entityManager.createQuery("Select c from Course c JOIN FETCH c.students s", Course.class)
				.getResultList();
		for (Course course : courses) {
			System.out.println(course + " " + course.getStudents());
		}
	}

	public void updateCourse(Course course) {
		entityManager.merge(course);
	}

	public void createCourseWithStudents(Course course, Student... students) {

		for (Student student : students) {
			course.addStudent(student);
			student.addCourse(course);
			if (student.getId() == null) {
				entityManager.persist(student);
			}
		}

		createCourse(course);

	}

	public void createReviewsForCourse(Course course, Review... reviews) {
		for (Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			if (review.getId() == null) {
				entityManager.persist(review);
			}
		}
	}

}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/repository/EntityManagerRepository.java

```java
package com.in28minutes.jpa.jpademo.relationships.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.jpademo.relationships.entity.Passport;

@Repository
@Transactional
public class EntityManagerRepository {

	@Autowired
	EntityManager entityManager;

	public void doSomething() {
		Passport passport = new Passport("E123456");
		entityManager.persist(passport);
		entityManager.flush();
		passport.setNumber("E123457");
		// entityManager.clear();
		// entityManager.detach(passport);
		// entityManager.refresh(passport);
		// entityManager.remove(passport);
		// entityManager.merge(passport);
		// Queries
		// Entity Graphs
	}
}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/repository/StudentRepository.java

```java
package com.in28minutes.jpa.jpademo.relationships.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Passport;
import com.in28minutes.jpa.jpademo.relationships.entity.Review;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager entityManager;

	public void createStudentWithPassport(Student student, Passport passport) {
		student.setPassport(passport);
		//passport.setStudent(student);
		entityManager.persist(passport);
		entityManager.persist(student);
				
	}
}
```
---

### /src/main/java/com/in28minutes/jpa/jpademo/relationships/repository/TransactionManagementRepository.java

```java
package com.in28minutes.jpa.jpademo.relationships.repository;

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

### /src/main/resources/application.properties

```properties
spring.h2.console.enabled=true
spring.jpa.properties.hibernate.generate_statistics=true
logging.level.org.hibernate.stat=debug
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
#logging.level.org.hibernate.type=TRACE
spring.jpa.properties.hibernate.cache.use_second_level_cache=true
spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory
spring.jpa.properties.javax.persistence.sharedCache.mode=ENABLE_SELECTIVE
logging.level.net.sf.ehcache=debug
```
---

### /src/main/resources/data.sql

```
insert into course(id, name)
values(10101,'Caching in 100 Steps');
```
---

### /src/test/java/com/in28minutes/jpa/jpademo/CriteriaQueryDemoApplicationTest.java

```java
package com.in28minutes.jpa.jpademo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Course_;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class CriteriaQueryDemoApplicationTest {

	// @LocalServerPort
	// String port;

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
		Predicate condition = cb.like(course.get(Course_.name), "%100 Steps");
		cq.where(condition);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);

		assertEquals(2, courses.size());
		System.out.println(courses);
	}

	@Test
	public void basic_empty_courses() {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> course = cq.from(Course.class);
		Predicate condition = cb.isEmpty(course.get(Course_.students));
		cq.where(condition);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);

		assertEquals(1, courses.size());
		System.out.println(courses);
	}

	@Test
	public void basic_courses_order_by() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> course = cq.from(Course.class);
		cq.orderBy(cb.desc(course.get(Course_.name)));
		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);

	}

	@Test
	public void join() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> course = cq.from(Course.class);
		Join<Course, Student> student = course.join(Course_.students);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);
		assertEquals(5, courses.size());
	}

	@Test
	public void left_outer_join() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> course = cq.from(Course.class);
		Join<Course, Student> student = course.join(Course_.students, JoinType.LEFT);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(course));

		List<Course> courses = query.getResultList();
		System.out.println(courses);
		assertEquals(6, courses.size());
	}
}
```
---

### /src/test/java/com/in28minutes/jpa/jpademo/EntityManagerDemoApplicationTests.java

```java
package com.in28minutes.jpa.jpademo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.repository.EntityManagerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class EntityManagerDemoApplicationTests {

	@Autowired
	EntityManagerRepository entityManagerRepository;

	@Test
	public void someTest() {
		entityManagerRepository.doSomething();
	}
}
```
---

### /src/test/java/com/in28minutes/jpa/jpademo/InheritanceDemoApplicationTest.java

```java
package com.in28minutes.jpa.jpademo;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.inheritence.entity.FullTimeEmployee;
import com.in28minutes.jpa.jpademo.inheritence.entity.PartTimeEmployee;
import com.in28minutes.jpa.jpademo.inheritence.repository.EmployeeRepository;

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

### /src/test/java/com/in28minutes/jpa/jpademo/JpaDemoApplicationTests.java

```java
package com.in28minutes.jpa.jpademo;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Passport;
import com.in28minutes.jpa.jpademo.relationships.entity.Review;
import com.in28minutes.jpa.jpademo.relationships.entity.ReviewRating;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;
import com.in28minutes.jpa.jpademo.relationships.entity.StudentType;
import com.in28minutes.jpa.jpademo.relationships.repository.CourseRepository;
import com.in28minutes.jpa.jpademo.relationships.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class JpaDemoApplicationTests {

	// @LocalServerPort
	// String port;

	@Autowired
	EntityManager entityManager;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	@Test
	public void createCourseWithStudents() {
		Student student = new Student("Ranga", StudentType.FullTime);
		courseRepository.createCourseWithStudents(new Course("Spring in 100 Steps"), student);
		courseRepository.createCourseWithStudents(new Course("Spring Boot in 100 Steps"), student);
	}

	@Test
	public void createReviewsForCourse() {
		Course course = new Course("JPA in 100 Steps");
		courseRepository.createCourse(course);
		courseRepository.createReviewsForCourse(course, new Review(ReviewRating.FIVE, "Awesome Course"),
				new Review(ReviewRating.FIVE, "Wow!"));
		
	}

	@Test
	public void createCourse() {
		courseRepository.createCourse(new Course("JPA in 100 Steps"));
	}

	@Test
	@Transactional
	public void createStudentWithPassport() {
		Student student = new Student("Ranga", StudentType.FullTime);
		Passport passport = new Passport("A12345678");
		studentRepository.createStudentWithPassport(student, passport);
	}

	@Test
	public void updateCourse() {
		Course course = courseRepository.retrieveCourse(10001L);
		course.setName("JPA in 100 Steps - updated");
		course.setActiveFrom(LocalDate.of(2018, Month.APRIL, 10));
		courseRepository.updateCourse(course);
	}

	@After
	public void printAllData() {
		System.out.println("Dummy");
	}
}
```
---

### /src/test/java/com/in28minutes/jpa/jpademo/JPQLDemoApplicationTest.java

```java
package com.in28minutes.jpa.jpademo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class JPQLDemoApplicationTest {

	// @LocalServerPort
	// String port;

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

	@Test
	public void basic_empty_courses() {
		Query query = entityManager.createQuery("SELECT c FROM Course c WHERE c.students IS EMPTY");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic_courses_with_min_three_students() {
		Query query = entityManager.createQuery("SELECT c FROM Course c WHERE size(c.students) >= 3");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic_courses_order_by() {
		Query query = entityManager.createQuery("SELECT c FROM Course c ORDER BY size(c.students) DESC");
		List resultList = query.getResultList();
		assertEquals(3, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic3() {
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.passport.number like 'N%'");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic4() {
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.passport.number like 'N%'");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	// BETWEEN 100 and 1000
	// IS NULL
	// upper, lower, trim, length
	// Group by, having
	
	
	@Test
	public void join() {
		Query query = entityManager.createQuery("SELECT c, s FROM Course c JOIN c.students s");
		List resultList = query.getResultList();
		System.out.println(resultList.get(1).getClass());
		assertEquals(5, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void left_outer_join() {
		Query query = entityManager.createQuery("SELECT c, s FROM Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		assertEquals(6, resultList.size());
		for (Object[] result : resultList) {
			Course course = (Course) result[0];
			Student student = (Student) result[1];
			System.out.println(course + " " + student);
		}
	}

	@Test
	public void cross_join() {
		Query query = entityManager.createQuery("SELECT c, s FROM Course c, Student s");
		List resultList = query.getResultList();
		assertEquals(12, resultList.size());
		System.out.println(resultList);
	}

}
```
---

### /src/test/java/com/in28minutes/jpa/jpademo/NativeQueriesDemoApplicationTest.java

```java
package com.in28minutes.jpa.jpademo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Course;
import com.in28minutes.jpa.jpademo.relationships.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class NativeQueriesDemoApplicationTest {

	// @LocalServerPort
	// String port;

	@Autowired
	EntityManager entityManager;

	@Test
	public void basic() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Course c");
		System.out.println(query.getResultList());
	}

	@Test
	public void basic_with_parameter() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Course c where c.id = ?");
		query.setParameter(1	, 10001L);
		
		List resultList = query.getResultList();
		assertEquals(1,resultList.size());

		System.out.println(resultList);
	}

	@Test
	public void basic_with_named_parameter() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Course c where c.id = :id");
		query.setParameter("id", 10001L);
		
		List resultList = query.getResultList();
		assertEquals(1,resultList.size());

		System.out.println(resultList);
	}
	
	@Test
	public void basic_with_named_native_query() {
	}

	@Test
	@Transactional
	public void updating_a_number_of_rows() {
		Query query = entityManager.createNativeQuery("Update Course Set create_date_time=sysdate()");
		int executeUpdate = query.executeUpdate();
		System.out.println(executeUpdate);
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

	@Test
	public void basic_empty_courses() {
		Query query = entityManager.createQuery("SELECT c FROM Course c WHERE c.students IS EMPTY");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic_courses_with_min_three_students() {
		Query query = entityManager.createQuery("SELECT c FROM Course c WHERE size(c.students) >= 3");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic_courses_order_by() {
		Query query = entityManager.createQuery("SELECT c FROM Course c ORDER BY size(c.students) DESC");
		List resultList = query.getResultList();
		assertEquals(3, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic3() {
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.passport.number like 'N%'");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void basic4() {
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.passport.number like 'N%'");
		List resultList = query.getResultList();
		assertEquals(1, resultList.size());
		System.out.println(resultList);
	}

	// BETWEEN 100 and 1000
	// IS NULL
	// upper, lower, trim, length
	// Group by, having
	
	
	@Test
	public void join() {
		Query query = entityManager.createQuery("SELECT c, s FROM Course c JOIN c.students s");
		List resultList = query.getResultList();
		System.out.println(resultList.get(1).getClass());
		assertEquals(5, resultList.size());
		System.out.println(resultList);
	}

	@Test
	public void left_outer_join() {
		Query query = entityManager.createQuery("SELECT c, s FROM Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		assertEquals(6, resultList.size());
		for (Object[] result : resultList) {
			Course course = (Course) result[0];
			Student student = (Student) result[1];
			System.out.println(course + " " + student);
		}
	}

	@Test
	public void cross_join() {
		Query query = entityManager.createQuery("SELECT c, s FROM Course c, Student s");
		List resultList = query.getResultList();
		assertEquals(12, resultList.size());
		System.out.println(resultList);
	}

}
```
---

### /src/test/java/com/in28minutes/jpa/jpademo/PerformanceDemoApplicationTest.java

```java
package com.in28minutes.jpa.jpademo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PerformanceDemoApplicationTest {

	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void testNplus1(){
		courseRepository.printAllCourseAndStudents();
		//courseRepository.printAllCourseAndStudentsDynamicSubgraph();
		//courseRepository.printAllCourseAndStudentsJoinFetch();
	}


}
```
---

### /src/test/java/com/in28minutes/jpa/jpademo/TransactionManagementDemoApplicationTests.java

```java
package com.in28minutes.jpa.jpademo;

import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.jpademo.relationships.entity.Passport;
import com.in28minutes.jpa.jpademo.relationships.repository.TransactionManagementRepository;

@RunWith(SpringRunner.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class TransactionManagementDemoApplicationTests {

	@Autowired
	TransactionManagementRepository transactionManagementRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	public void someTest() {
		
		try {
			transactionManagementRepository.doSomething();
		} catch (Exception e) { }
		
		assertNull(entityManager.find(Passport.class, 1L));
	}
}
```
---

### /src/test/resources/data.sql

```
insert into passport(id, number)
values(40001, 'L123456');

insert into passport(id, number)
values(40002, 'M123456');

insert into passport(id, number)
values(40003, 'N123456');

insert into passport(id, number)
values(40004, 'O123456');


insert into course(id, name)
values(10001,'Spring in 100 Steps');

insert into course(id, name)
values(10002,'Spring Boot in 100 Steps');

insert into course(id, name)
values(10003,'JPA in 50 Steps');

insert into student(id, name,passport_id)
values(20001, 'Adam',40001);

insert into student(id, name,passport_id)
values(20002, 'Buck',40002);

insert into student(id, name,passport_id)
values(20003, 'Chris',40003);

insert into student(id, name,passport_id)
values(20004, 'Dennis',40004);


insert into course_students(courses_id,students_id)
values(10001,20001);

insert into course_students(courses_id,students_id)
values(10001,20002);

insert into course_students(courses_id,students_id)
values(10001,20003);

insert into course_students(courses_id,students_id)
values(10002,20001);

insert into course_students(courses_id,students_id)
values(10002,20002);
```
---
