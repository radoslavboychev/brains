
## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.spring.basics</groupId>
	<artifactId>spring-in-5-steps</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-in-5-steps</name>
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
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
		</dependency>

		<dependency>
			<groupId>javax.inject</groupId>
			<artifactId>javax.inject</artifactId>
			<version>1</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>

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
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
		</dependency>

		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-core</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
		</dependency>
		<!-- <dependency> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-test</artifactId> 
			<scope>test</scope> </dependency> -->
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
	</pluginRepositories>


</project>
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/aop/AfterExecutionAOPConfig.java

```java
package com.in28minutes.spring.basics.springin5steps.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterExecutionAOPConfig {
	@After("com.in28minutes.spring.basics.springin5steps.aop.AOPArchitectureConfig.anyMethod()")
	//@AfterReturning
	//@AfterThrowing
	public void after(JoinPoint joinPoint) {
		System.out.println("Clean up after " + joinPoint.getSignature().toString());
	}

}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/aop/AOPArchitectureConfig.java

```java
package com.in28minutes.spring.basics.springin5steps.aop;

import org.aspectj.lang.annotation.Pointcut;

public class AOPArchitectureConfig {
	
	//@Pointcut("within(com.in28minutes.spring.basics.springin5steps.aop.business..*)")
	//@Pointcut("businessService() && dataService()")
	@Pointcut("execution(* com.in28minutes.spring.basics.springin5steps.aop.business.*.*(..))")
    public void businessService() {}

	@Pointcut("execution(* com.in28minutes.spring.basics.springin5steps.aop.data.*.*(..))")
    public void dataService() {}

	@Pointcut("bean(*dao*)")
    public void daoServices() {}

	//@Pointcut("execution(* com.in28minutes.spring.basics.springin5steps.aop.*.*.*(..))")
	@Pointcut("within(com.in28minutes.spring.basics.springin5steps.aop..*)")
	public void anyMethod() {}
	
	@Pointcut("@annotation(com.in28minutes.spring.basics.springin5steps.aop.business.TrackTime) ")
	public void trackTime() {}

}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/aop/business/Business1.java

```java
package com.in28minutes.spring.basics.springin5steps.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.spring.basics.springin5steps.aop.data.Dao1;

@Service
public class Business1 {
	@Autowired
	private Dao1 dao;
	
	@TrackTime
	public String getSomething(){
		return dao.retrieveSomeData();
	}
}

```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/aop/business/Business2.java

```java
package com.in28minutes.spring.basics.springin5steps.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.spring.basics.springin5steps.aop.data.Dao2;

@Service
public class Business2 {
	
	@Autowired
	private Dao2 dao;
	
	public String getSomething(){
		return dao.retrieveSomeData();
	}
}

```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/aop/business/TrackTime.java

```java
package com.in28minutes.spring.basics.springin5steps.aop.business;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {

}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/aop/BusinessAcessCheckAOPConfig.java

```java
package com.in28minutes.spring.basics.springin5steps.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BusinessAcessCheckAOPConfig {
	@Before("com.in28minutes.spring.basics.springin5steps.aop.AOPArchitectureConfig.businessService()")
	public void before(JoinPoint joinPoint) {
		System.out.println("Before ");
		System.out.println(joinPoint.getSignature().toString() + " called with ");
		System.out.println(Arrays.toString(joinPoint.getArgs()));
		System.out.println("I Will check if the user has the right access");
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/aop/data/Dao1.java

```java
package com.in28minutes.spring.basics.springin5steps.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

	public String retrieveSomeData() {
		return "Dao1";
	}

}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/aop/data/Dao2.java

```java
package com.in28minutes.spring.basics.springin5steps.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {
	public String retrieveSomeData() {
		return "Dao2";
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/aop/LogExecutionTimeAOPConfig.java

```java
package com.in28minutes.spring.basics.springin5steps.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogExecutionTimeAOPConfig {
	@Around("com.in28minutes.spring.basics.springin5steps.aop.AOPArchitectureConfig.trackTime()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		System.out.println("Time taken by " + joinPoint.getSignature().toString() + " is "
				+ (System.currentTimeMillis() - startTime));
		return proceed;
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/basics/BinarySearchImpl.java

```java
package com.in28minutes.spring.basics.springin5steps.basics;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		// Search the array
		return 3;
	}

	
	@PostConstruct
	public void postConstruct(){
		System.out.println("Post construct");
	}
	
	@PreDestroy
	public void preDestroy(){
		System.out.println("Pre Destroy");
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/basics/BubbleSortAlgorithm.java

```java
package com.in28minutes.spring.basics.springin5steps.basics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		return numbers;
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/basics/QuickSortAlgorithm.java

```java
package com.in28minutes.spring.basics.springin5steps.basics;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Quick Sort
		return numbers;
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/basics/SortAlgorithm.java

```java
package com.in28minutes.spring.basics.springin5steps.basics;

public interface SortAlgorithm {
	public int[] sort(int[] numbers);
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/cdi/SomeCDIBusiness.java

```java
package com.in28minutes.spring.basics.springin5steps.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCDIBusiness {
	@Inject
	private SomeCDIDAO someDao;

	public SomeCDIBusiness() {
		super();
	}

	public SomeCDIBusiness(SomeCDIDAO someDao) {
		super();
		this.someDao = someDao;
	}

	public void setSomeDao(SomeCDIDAO someDao) {
		this.someDao = someDao;
	}

	public int sum() {
		int[] data = someDao.getData();
		int sum = 0;
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/cdi/SomeCDIDAO.java

```java
package com.in28minutes.spring.basics.springin5steps.cdi;

import javax.inject.Named;

@Named
public class SomeCDIDAO {
	public int[] getData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/jdbc/Person.java

```java
package com.in28minutes.spring.basics.springin5steps.jdbc;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(query = "select p from Person p", name = "find_all_persons_query")
public class Person {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String location;

	private Date birthDate;

	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public Person() {

	}

	public Person(String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("\nPerson [id=%s, name=%s, location=%s, birthDate=%s]", id, name, location, birthDate);
	}

}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/jdbc/PersonJpaRepository.java

```java
package com.in28minutes.spring.basics.springin5steps.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Person> findAll() {
		Query query = entityManager.createNamedQuery("find_all_persons_query", Person.class);
		return query.getResultList();
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public void insert(Person person) {
		entityManager.merge(person);
	}

	public void update(Person person) {
		entityManager.merge(person);
	}

	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/jdbc/PersonSpringJdbcDao.java

```java
package com.in28minutes.spring.basics.springin5steps.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonSpringJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// new BeanPropertyRowMapper(Person.class)
	class PersonMapper implements RowMapper<Person> {
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("location"),
					rs.getTimestamp("birth_date"));
			return person;
		}
	}

	public List<Person> findAll() {
		return jdbcTemplate.query("SELECT * FROM person", new PersonMapper());

	}

	public Person findById(int id) {

		return jdbcTemplate.queryForObject("SELECT * FROM person where id=?", new Object[] { id }, new PersonMapper());

	}

	public void insert(Person person) {
		jdbcTemplate.update("insert into person(id, birth_date,location, name) values(?,?,?,?)", person.getId(),
				new Timestamp(person.getBirthDate().getTime()), person.getLocation(), person.getName());

	}

	public void update(Person person) {
		jdbcTemplate.update("Update person set name=?, location=?, birth_date=? where id=?", person.getName(),
				person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId());

	}

	public void deleteById(int id) {
		jdbcTemplate.update("delete from person where id=?", id);
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/profiles/Cacheable.java

```java
package com.in28minutes.spring.basics.springin5steps.profiles;

public interface Cacheable {
	void doSomething();
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/profiles/DistributedCache.java

```java
package com.in28minutes.spring.basics.springin5steps.profiles;

public class DistributedCache implements Cacheable {

	@Override
	public void doSomething() {
		System.out.println("Distributed Cache");
	}

}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/profiles/NormalCache.java

```java
package com.in28minutes.spring.basics.springin5steps.profiles;

public class NormalCache implements Cacheable {

	@Override
	public void doSomething() {
		System.out.println("Normal Cache");
	}

}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/profiles/ProfileConfiguration.java

```java
package com.in28minutes.spring.basics.springin5steps.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfiguration {
	@Bean
	@Profile("default")
	public Cacheable getDev() {
		return new NormalCache();
	}

	@Bean
	@Profile("prod")
	public Cacheable getProd() {
		return new DistributedCache();
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/properties/SomeExternalService.java

```java
package com.in28minutes.spring.basics.springin5steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeExternalService {
	
	@Value("${service.url}")
	private String service;
	
	public void callService(){
		System.out.println(service);
	}
	

}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/scope/PersonDAO.java

```java
package com.in28minutes.spring.basics.springin5steps.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PersonDAO {

	@Autowired
	private PersonJDBCConnection connection;

	public PersonJDBCConnection getConnection() {
		return connection;
	}

	public void setConnection(PersonJDBCConnection connection) {
		this.connection = connection;
	}

}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/scope/PersonJDBCConnection.java

```java
package com.in28minutes.spring.basics.springin5steps.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonJDBCConnection {
	public PersonJDBCConnection() {
		System.out.println("new PersonJDBCConnection");
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsApplication.java

```java
package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.springin5steps.basics.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.scope.PersonDAO;

@SpringBootApplication
public class SpringIn5StepsApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		System.out.println(result);
		PersonDAO personDAO1 = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		System.out.println(personDAO1);
		System.out.println(personDAO2);
		System.out.println(personDAO1.getConnection());
		System.out.println(personDAO2.getConnection());

	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsAspectApplication.java

```java
package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.springin5steps.aop.business.Business1;
import com.in28minutes.spring.basics.springin5steps.aop.business.Business2;

@SpringBootApplication
public class SpringIn5StepsAspectApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsAspectApplication.class, args);
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
		Business1 business1 = applicationContext.getBean(Business1.class);
		Business2 business2 = applicationContext.getBean(Business2.class);
		System.out.println(business1.getSomething());
		System.out.println(business2.getSomething());
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsCacheableApplication.java

```java
package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import com.in28minutes.spring.basics.springin5steps.basics.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.profiles.Cacheable;
import com.in28minutes.spring.basics.springin5steps.scope.PersonDAO;

@SpringBootApplication
public class SpringIn5StepsCacheableApplication {
	
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsCacheableApplication.class, args);
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		System.out.println(result);
		PersonDAO personDAO1 = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		System.out.println(personDAO1);
		System.out.println(personDAO2);
		System.out.println(personDAO1.getConnection());
		System.out.println(personDAO2.getConnection());
		
		Cacheable cache = applicationContext.getBean(Cacheable.class);
		cache.doSomething();
		
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsJavaContext.java

```java
package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.spring.basics.springin5steps.basics.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.cdi.SomeCDIBusiness;

@ComponentScan
@Configuration
public class SpringIn5StepsJavaContext {

	public static void main(String[] args) {

		try(AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsJavaContext.class)){
			System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

			BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

			int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);

			System.out.println(result);

			SomeCDIBusiness someCDIBusiness = applicationContext.getBean(SomeCDIBusiness.class);

			int result2 = someCDIBusiness.sum();

			System.out.println(result2);
		};


	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsJdbcApplication.java

```java
package com.in28minutes.spring.basics.springin5steps;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.springin5steps.jdbc.Person;
import com.in28minutes.spring.basics.springin5steps.jdbc.PersonSpringJdbcDao;

@SpringBootApplication
public class SpringIn5StepsJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsJdbcApplication.class, args);
	}

	@Autowired
	PersonSpringJdbcDao jdbcService;

	@Override
	public void run(String... args) throws Exception {

		jdbcService.insert(new Person(10001, "Ranga Karanam", "Hyderabad", new Date()));
		jdbcService.insert(new Person(10002, "Jack", "Charleston", new Date()));
		jdbcService.insert(new Person(10003, "Ravi", "Charleston", new Date()));
		jdbcService.insert(new Person(10004, "Satish", "Charleston", new Date()));
		jdbcService.insert(new Person(10005, "Jim", "Charleston", new Date()));

		jdbcService.update(new Person(10002, "Jack", "Greenville", new Date()));

		System.out.println(jdbcService.findById(10002));

		System.out.println(jdbcService.findAll());

		jdbcService.deleteById(10002);
		System.out.println("After deleting 10002");
		System.out.println(jdbcService.findAll());
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsJpaApplication.java

```java
package com.in28minutes.spring.basics.springin5steps;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.springin5steps.jdbc.Person;
import com.in28minutes.spring.basics.springin5steps.jdbc.PersonJpaRepository;

@SpringBootApplication
public class SpringIn5StepsJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsJpaApplication.class, args);
	}

	@Autowired
	PersonJpaRepository jpaService;

	@Override
	public void run(String... args) throws Exception {

		jpaService.insert(new Person("Ranga Karanam", "Hyderabad", new Date()));
		jpaService.insert(new Person("Jack", "Charleston", new Date()));
		jpaService.insert(new Person("Ravi", "Charleston", new Date()));
		jpaService.insert(new Person("Satish", "Charleston", new Date()));
		jpaService.insert(new Person("Jim", "Charleston", new Date()));

		jpaService.update(new Person(2, "Jack", "Greenville", new Date()));

		System.out.println(jpaService.findById(2));

		System.out.println(jpaService.findAll());

		jpaService.deleteById(2);
		System.out.println("After deleting 2");
		System.out.println(jpaService.findAll());
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsPropertiesContext.java

```java
package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.in28minutes.spring.basics.springin5steps.properties.SomeExternalService;

@ComponentScan
@Configuration
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesContext {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringIn5StepsPropertiesContext.class)) {
			System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

			SomeExternalService someBean = applicationContext.getBean(SomeExternalService.class);
			someBean.callService();
		}
		;

	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsXMLContext.java

```java
package com.in28minutes.spring.basics.springin5steps;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.spring.basics.springin5steps.basics.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.xml.SomeBusiness;

public class SpringIn5StepsXMLContext {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

		SomeBusiness someBusiness = applicationContext.getBean(SomeBusiness.class);

		int result = someBusiness.sum();

		System.out.println(result);
		
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

		int result2 = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);

		System.out.println(result2);
		
		applicationContext.close();
		
		System.out.println("Context Closed");

	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/xml/SomeBusiness.java

```java
package com.in28minutes.spring.basics.springin5steps.xml;

public class SomeBusiness {
	private SomeDAO someDao;

	public SomeBusiness() {
		super();
	}

	public SomeBusiness(SomeDAO someDao) {
		super();
		this.someDao = someDao;
	}

	public void setSomeDao(SomeDAO someDao) {
		this.someDao = someDao;
	}

	public int sum() {
		int[] data = someDao.getData();
		int sum = 0;
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/xml/SomeDAO.java

```java
package com.in28minutes.spring.basics.springin5steps.xml;

import javax.inject.Named;

@Named
public class SomeDAO {
	public int[] getData() {
		return new int[] { 1, 2, 3, 4, 5, 6 };
	}
}
```
---

### /src/main/resources/app.properties

```properties
service.url=http://some.server.com/doSomething
```
---

### /src/main/resources/app_prod.properties

```properties
service.url=http://prod.server.com/doSomething
```
---

### /src/main/resources/application.properties

```properties
#logging.level.org.springframework = debug
spring.h2.console.enabled=true
spring.jpa.show-sql=true
```
---

### /src/main/resources/applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- Search Google For "spring documentation example spring application context" -->
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
	<context:component-scan base-package="com.in28minutes.spring.basics.springin5steps"></context:component-scan>

	<bean id="someDao" class="com.in28minutes.spring.basics.springin5steps.xml.SomeDAO">
		<!-- collaborators and configuration for this bean go here -->
	</bean>

	<bean id="someBusiness"
		class="com.in28minutes.spring.basics.springin5steps.xml.SomeBusiness">
		<!-- <property name="someDAO" ref="someDAO" /> -->
		<!-- <property name="someDao" ref="someDao" /> -->
		<property name="someDao" ref="someDao" />
	</bean>
	<!-- <bean id="someBusiness2" class="com.in28minutes.spring.basics.springin5steps.xml.SomeBusiness"> 
		<constructor-arg> <ref bean="someDao" /> </constructor-arg> </bean> -->

	<!-- more bean definitions go here -->

</beans>
```
---

### /src/main/resources/data.sql

```
/*
create table person
(
	id integer not null,
	birth_date timestamp,
	location varchar(255),
	name varchar(255),
	primary key (id)
);
*/
```
---

### /src/main/resources/log.txt

```
Searching directory [/in28Minutes/git/getting-started-in-5-steps/spring-in-5-steps/target/classes/com/in28minutes/spring/basics/springin5steps] for files matching pattern [/in28Minutes/git/getting-started-in-5-steps/spring-in-5-steps/target/classes/com/in28minutes/spring/basics/springin5steps/**/*.class]
Identified candidate component class: file [/in28Minutes/git/getting-started-in-5-steps/spring-in-5-steps/target/classes/com/in28minutes/spring/basics/springin5steps/BinarySearchImpl.class]
Identified candidate component class: file [/in28Minutes/git/getting-started-in-5-steps/spring-in-5-steps/target/classes/com/in28minutes/spring/basics/springin5steps/BubbleSortAlgorithm.class]

Creating instance of bean 'binarySearchImpl'
Creating instance of bean 'bubbleSortAlgorithm'
Finished creating instance of bean 'bubbleSortAlgorithm'

Constuctor - Autowiring by type from bean name 'binarySearchImpl' via constructor 
to bean named 'bubbleSortAlgorithm'
Setter -  Autowiring by type from bean name 'binarySearchImpl' to bean named 'bubbleSortAlgorithm'
No Setter or Constructor - Autowiring by type from bean name 'binarySearchImpl' to bean named 'bubbleSortAlgorithm'


Finished creating instance of bean 'binarySearchImpl'
```
---

### /src/test/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsApplicationTests.java

```java
package com.in28minutes.spring.basics.springin5steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringIn5StepsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /src/test/java/com/in28minutes/spring/basics/springin5steps/xml/SomeBusinessJavaTest.java

```java
package com.in28minutes.spring.basics.springin5steps.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.spring.basics.springin5steps.SpringIn5StepsJavaContext;
import com.in28minutes.spring.basics.springin5steps.basics.BinarySearchImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringIn5StepsJavaContext.class)
public class SomeBusinessJavaTest {

	@Autowired
	private BinarySearchImpl search;

	@Test
	public void contextLoads() {
		int result = search.binarySearch(new int[] {}, 5);
		assertEquals(3, result);
	}

}
```
---

### /src/test/java/com/in28minutes/spring/basics/springin5steps/xml/SomeBusinessMockTest.java

```java
package com.in28minutes.spring.basics.springin5steps.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@InjectMocks
	private SomeBusiness business;

	@Mock
	private SomeDAO dao;

	@Test
	public void contextLoads() {
		Mockito.when(dao.getData()).thenReturn(new int[] { 1, 2, 3 });
		int result = business.sum();
		assertEquals(6, result);
	}

}
```
---

### /src/test/java/com/in28minutes/spring/basics/springin5steps/xml/SomeBusinessXMLTest.java

```java
package com.in28minutes.spring.basics.springin5steps.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class SomeBusinessXMLTest {
	
	@Autowired
	private SomeBusiness business;

	@Test
	public void contextLoads() {
		int result = business.sum();
		assertEquals(21,result);
	}

}
```
---
