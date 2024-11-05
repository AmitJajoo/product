# Product Management API

## Overview
This project is a RESTful API for managing products using Spring Boot.

## Technologies Used
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger for API documentation

## Features
- CRUD operations for products
- Input validation
- Global exception handling
- Swagger UI for API visualization

## Getting Started

### Prerequisites
- JDK 17 or later
- Gradle
- PostgreSQL database

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/AmitJajoo/product.git
2. Configure your database in src/main/resources/application.properties
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/yourdb
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   
## Running the Application
1. Build the project:
   ```properties
   ./gradlew build

2. Run the application:
   ```properties
   ./gradlew bootRun


3. Once the application is running, you can access the API documentation at:
   ```properties
    http://localhost:8080/swagger-ui/index.html



## API Endpoints

### Products

- **GET /products**: Retrieve all products.
- **GET /products/{id}**: Retrieve a product by ID.
- **POST /products**: Create a new product.
- **PUT /products/{id}**: Update a product by ID.
- **DELETE /products/{id}**: Delete a product by ID.

## Custom Error Messages
The API includes custom error messages for validation failures. These messages are returned in the response JSON.

## Exception Handling
Global exception handling is implemented using @ControllerAdvice to manage and format error responses, including handling bad requests and internal server errors.
