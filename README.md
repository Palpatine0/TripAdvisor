# TripAdvisor Imitation Project

This project is an imitation of the popular TripAdvisor platform, developed using Spring Boot. It includes features such as user management, roles, and permissions.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Features

- User authentication and authorization
- Role-based access control
- Management of categories, comments, favorites, members, products, and roles

## Prerequisites

Before you begin, ensure you have the following installed:

- Java 8
- Maven 3.6.3
- MySQL 5.7 or higher

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Palpatine0/TripAdvisor.git
   cd TripAdvisor


2. Install the dependencies:
   ```bash
   mvn clean install
   ```

## Database Setup

1. Create a new MySQL database named `trip_advisor`.

2. Execute the SQL script located at `src/main/resources/seeds/trip_advisor.sql` to create the necessary tables and seed data. Use the following command to import the SQL file:
   ```bash
   mysql -u root -p trip_advisor < src/main/resources/seeds/trip_advisor.sql
   ```

## Configuration

Update the `application.yml` file located in `src/main/resources` with your database credentials and other settings:

```yaml
server:
  port: 9999

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    # dev
    url: jdbc:mysql:///trip_advisor?characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true&zeroDateTimeBehavior=CONVERT_TO_NULL&allowPublicKeyRetrieval=true
    # prd
    # url: jdbc:mysql://prd_tripadvisor_svc_mysql:3306/trip_advisor?characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true&zeroDateTimeBehavior=CONVERT_TO_NULL&allowPublicKeyRetrieval=true
    username: root
    password: root
  servlet:
    multipart:
      max-file-size: 10MB
      max-request-size: 10MB
  thymeleaf:
    mode: HTML
    cache: false
    prefix: classpath:/templates

mybatis-plus:
  global-config:
    db-config:
      id-type: auto
  configuration:
    map-underscore-to-camel-case: false
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

logging:
  pattern:
    console: '%d{HH:mm:ss.SSS}%clr(%-5level) --- [%-15thread]%cyan(%-50logger{50}):%msg%n'

project:
  # dev
  path: http://localhost:9999
```

## Running the Application

1. Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

2. Open your browser and navigate to `http://localhost:9999`.

## Project Structure

- `src/main/java/com/example/tripadvisor`: Contains the source code for the application.
- `src/main/resources`: Contains the application's configuration files.
- `src/main/resources/seeds/trip_advisor.sql`: SQL script for setting up the database.

## Dependencies

The project includes the following key dependencies:

- Spring Boot Starter Thymeleaf
- Thymeleaf Extras Spring Security 5
- MySQL Connector/J
- MyBatis Plus Boot Starter
- Project Lombok
- Spring Boot Starter Security
- Spring Boot Starter AOP
- Spring Boot Starter Mail
- Spring Boot DevTools
- Spring Boot Starter Web
- Spring Boot Starter Test

For a complete list of dependencies, see the `pom.xml` file.

## Contributing

Contributions are welcome! Please fork this repository and submit pull requests with appropriate changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
```

This README includes detailed setup instructions, configuration information, and a description of the project structure. Make sure to replace placeholder information such as the database username and password with actual values.