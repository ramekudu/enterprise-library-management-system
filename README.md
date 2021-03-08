# Enterprise library management system.

#### This is a spring boot microservices project.

### Tech stack:
- Spring Boot
- Spring Data Jpa
- H2 Database

### Requirements

For building and running the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or newer
- [Maven 3](https://maven.apache.org)
- [Lombok](https://projectlombok.org)

### Build & Run

```
  mvn clean install && mvn --projects backend spring-boot:run
```

### Port
```
  http://localhost:8083
```
### To access H2 database from console

http://localhost:8083/h2-console
 and key in the jdbcUrl as jdbc:h2:mem:librarydb
 user name:- sa
 password :- password.
