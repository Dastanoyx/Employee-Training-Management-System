# Employee Training Management System (ETMS)

## Overview

The **Employee Training Management System (ETMS)** is a Spring Boot application designed to manage employee training and related operations within an organization. It provides functionalities to manage employees, their badges, certifications, training sessions, and enrolments. The application follows a modular design using JPA (Java Persistence API) to map entities to a PostgreSQL database and exposes RESTful APIs for CRUD operations.

## Features

- **Employee Management**
    - Create, update, delete, and retrieve employee details.
    - Includes fields such as first name, last name, email, and position.

- **Employee Badge Management**
    - Manage employee badges linked to employees.
    - Each badge includes a unique number and is associated with an employee.

- **Training Management**
    - Create, update, delete, and retrieve training sessions.
    - Includes fields such as training name and department.

- **Enrolments**
    - Manage employee enrolments in training sessions using a composite key.
    - Tracks the enrollment date and links employees to their training.

- **Certificates**
    - Manage employee certifications.
    - Tracks the certificate name, issuing date, and associated employee.

- **RESTful APIs**
    - Endpoints for all CRUD operations related to employees, employee badges, and trainings.
    - Follows standard HTTP methods (`GET`, `POST`, `PUT`, `DELETE`).

## Configuration

### Database Configuration

Ensure PostgreSQL is installed and running. Update the `application.properties` file with your database credentials.

```properties
# Application Name
spring.application.name=Employee Training Management System

# Datasource Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=admin

# JPA and Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

### Prerequisites

- **Java 17 or later**
- **Maven** (for dependency management)
- **PostgreSQL**

### Running the Application

1. **Clone the repository:**
   ```bash
   git clone git@github.com:Dastanoyx/Employee-Training-Management-System.git
    ```
2. **Navigate to the project directory:**
   ```bash
   cd Employee-Training-Management-System
   ```
3. **Build the project:**
    ```bash
   mvn clean install
   ```
4. **Run the application:**
    ```bash
   mvn spring-boot:run
   ```
5. **Access the application via API endpoints:**

   Example: http://localhost:8080/api/employees

## REST API Endpoints

### Employee Endpoints

| Method   | URL                      | Description              |
|----------|--------------------------|--------------------------|
| `POST`   | `/api/employees`         | Create a new employee    |
| `PUT`    | `/api/employees/{id}`    | Update an employee       |
| `GET`    | `/api/employees/{id}`    | Get employee by ID       |
| `GET`    | `/api/employees`         | Get all employees        |
| `DELETE` | `/api/employees/{id}`    | Delete an employee       |

### Employee Badge Endpoints

| Method   | URL                           | Description             |
|----------|-------------------------------|-------------------------|
| `POST`   | `/api/employee-badges`        | Create a new badge      |
| `PUT`    | `/api/employee-badges/{id}`   | Update a badge          |
| `GET`    | `/api/employee-badges/{id}`   | Get badge by ID         |
| `GET`    | `/api/employee-badges`        | Get all badges          |
| `DELETE` | `/api/employee-badges/{id}`   | Delete a badge          |

### Training Endpoints

| Method   | URL                    | Description              |
|----------|------------------------|--------------------------|
| `POST`   | `/api/trainings`       | Create a training session|
| `PUT`    | `/api/trainings/{id}`  | Update a training session|
| `GET`    | `/api/trainings/{id}`  | Get training by ID       |
| `GET`    | `/api/trainings`       | Get all trainings        |
| `DELETE` | `/api/trainings/{id}`  | Delete a training session|
