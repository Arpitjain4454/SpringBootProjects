# Ecommerce
#### This is a sample Spring Boot E-commerce API project that provides basic CRUD operations for users, products, addresses, and orders. This project uses the following frameworks and technologies:

- Java
- Spring Boot
- H2 Database
-------

# Functionality
### The API provides the following functionality:

- Create a new user, product, or address
- Get a user, product, or order by ID
- Get all products or products by category
- Delete a product by ID
- Create a new order using a user ID, product ID, and address ID

----------------

# Project Structure
#### This project follows a standard Spring Boot project structure, with the following key components:

## Controller
This layer provides the RESTful API endpoints that handle HTTP requests and responses. It interacts with the services layer to perform business logic.

## Service
This layer provides the business logic for the application. It interacts with the repository layer to perform CRUD operations on the database.

## Repository
This layer provides the interface for interacting with the database. It uses Spring Data JPA to perform CRUD operations on the database.

## Model
This layer provides the data models used by the application. It defines the fields and relationships between entities in the application.

-----------

# Data Flow
#### The data flow in this project follows the standard flow for a Spring Boot application:

1. The HTTP request is sent to the appropriate endpoint in the controller layer.
2. The controller layer calls the appropriate method in the service layer.
3. The service layer performs any necessary business logic and calls the appropriate method in the repository layer.
4. The repository layer performs CRUD operations on the database.
5. The data is returned back up the layers to the controller layer, which sends an HTTP response.

------------

# Data Structure
#### This project uses the H2 in-memory database, which is configured in the application.properties file. The database schema is generated automatically based on the entity models defined in the application. The following entities are defined in this project:

- User
- Product
- Address
- Order

---------

# Running the Application
To run this application, you can either run the main method in the.
 - `EcommerceApiApplication`:class or use the Spring Boot Maven plugin with the command.
- `mvn spring-boot`:run. Once the application is running, you can test the API endpoints using a tool like Postman.

#### Note: that this is a sample project and there are many additional features and edge cases that would need to be considered in a real-world e-commerce API.

--------

# Project Summary
This is a sample Spring Boot E-commerce API project that provides basic CRUD operations for users, products, addresses, and orders. The API allows users to create new objects, such as users, products, and addresses, and retrieve them from the database using HTTP requests. It also allows users to delete products by ID and create new orders using a user ID, product ID, and address ID. The project uses the H2 in-memory database and follows a standard Spring Boot project structure, with separate layers for controllers, services, and repositories. The project also uses Spring Data JPA to perform CRUD operations on the database.

--------------
