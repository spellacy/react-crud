##Spring Boot
### Initializr
Gradle project with Spring Boot 1.4.4.RELEASE  
1. Web  
2. JAX-RS  
3. MySQL  
4. Lombok  
5. Flyway  
6. Thymeleaf (cuz why not add more new?)  

### Properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/react-crud
spring.datasource.username=react-crud-user
spring.datasource.password=react-crud-user
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

##Flyway
include the plugin in the gradle file so you can run flyway commands like `flywayClean` and `flywayMigrate` and `flywayInfo` from the command line
```
buildscript { 
	ext {  
		springBootVersion = '1.4.4.RELEASE'  
	}  
	repositories {  
		mavenCentral()  
        maven {  
            url "https://plugins.gradle.org/m2/"  
        }  
	}  
	dependencies {  
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")  
        classpath("mysql:mysql-connector-java:5.1.40")  
        classpath("org.springframework.boot:spring-boot-starter-jdbc:${springBootVersion}")  
        classpath("gradle.plugin.com.boxfuse.client:flyway-release:4.0.3")  
	}  
}  

apply plugin: "org.flywaydb.flyway"
```
##Lombok
Initially used Lombok `@Getter` and `@Setter` in domain objects but replaced with `@Data`.  I was also able to use `@AllArgsConstructor`

##React

##Todos
add security / session management  
what about data security   
owasp zap  
