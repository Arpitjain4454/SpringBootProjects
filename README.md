# Course Management Portal
#### This project provides a portal for managing courses and their relationships with students.

# Dependencies
#### The following dependencies are used in this project:

- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL Connector
- Spring Web

## Models
#### The following models are used in this project:

- Student
- Laptop
- Course
- Book
- Address

## Controllers
#### The following controllers are used in this project:

- StudentController
- LaptopController
- CourseController
- BookController
- AddressController

#### Each controller provides CRUD operations for its corresponding model via HTTP requests.

## Services
#### The following services are used in this project:

- StudentService
- LaptopService
- CourseService
- BookService
- AddressService
#### Each service handles business logic and interacts with the corresponding repository.

## Repositories
#### The following repositories are used in this project:

- StudentRepository
- LaptopRepository
- CourseRepository
- BookRepository
- AddressRepository
#### Each repository interacts with the database to perform CRUD operations on its corresponding model.

## Validation
#### Validation is used in this project to ensure that data is entered correctly and consistently. It is implemented using annotations from the javax.validation.constraints package.

## Usage
#### To use this project, follow these steps:

1. Install MySQL and create a database called course_management.
2. Update the application.properties file with your MySQL username and password.
3. Run the project using mvn spring-boot:run.
4. Use a tool such as Postman to send HTTP requests to the appropriate endpoints for CRUD operations on the models.

## Endpoints
#### The following endpoints are available for this project:

- `GET /api/students` - Get all students

- `GET /api/students/{id}` - Get a student by ID

- `POST /api/students` - Create a new student

- `PUT /api/students/{id}` - Update an existing student

- `DELETE /api/students/{id}` - Delete a student by ID

- `GET /api/laptops` - Get all laptops

- `GET /api/laptops/{id}` - Get a laptop by ID

- `POST /api/laptops` - Create a new laptop

- `PUT /api/laptops/{id}` - Update an existing laptop

- `DELETE /api/laptops/{id}` - Delete a laptop by ID

- `GET /api/courses` - Get all courses

- `GET /api/courses/{id}` - Get a course by ID

- `POST /api/courses` - Create a new course

- `PUT /api/courses/{id}` - Update an existing course

- `DELETE /api/courses/{id}` - Delete a course by ID

- `GET /api/books` - Get all books

- `GET /api/books/{id}` - Get a book by ID

- `POST /api/books` - Create a new book

- `PUT /api/books/{id}` - Update an existing book

- `DELETE /api/books/{id}` - Delete a book by ID

- `GET /api/addresses` - Get all addresses

- `GET /api/addresses/{id}` - Get an address by ID

- `POST /api/addresses` - Create a new address

- `PUT /api/addresses/{id}` - Update an existing address

- `DELETE /api/addresses/{id}` - Delete an address by ID

# Data Structure
#### The data structure for this project is based on object-oriented programming principles and is implemented using Java classes. The main entities in this project are Student, Laptop, Book, and Course, and each of these entities is represented by a Java class.

#### The relationships between these entities are managed using annotations, such as @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany, which are provided by the JPA framework. These annotations allow the relationships between the entities to be defined and enforced at the database level.

#### Additionally, the Address class is used as an embedded model within the Student class, allowing for the storage of address information within the Student entity.

#### In terms of data storage, this project uses a relational database management system (RDBMS) to store and manage the entities and their relationships. The JPA framework provides a layer of abstraction between the application and the database, allowing for easy management of the database without having to write SQL queries directly.

# Summary

#### This project is a Java-based web application that demonstrates the use of Spring Boot framework and JPA (Java Persistence API) for managing relationships between entities in a database. The application uses RESTful API to perform CRUD operations on four entities - Student, Laptop, Book, and Course. The relationships between these entities are modeled as one-to-one, one-to-many, many-to-one, and many-to-many relationships.

#### The project includes the implementation of controllers, services, and repositories for each entity. The code also includes validation checks for inputs and outputs, ensuring that the data being processed and returned is accurate and complete.

#### The project is built using Spring Boot, which provides an easy-to-use framework for building scalable and robust web applications. The project also uses JPA, which simplifies the management of database entities and relationships.

#### Overall, this project serves as an example of how to design and build a web application using Spring Boot and JPA, with an emphasis on managing entity relationships.
