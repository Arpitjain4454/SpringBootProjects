# Doctor Patient Management System
#### This is a Spring Boot application that manages the relationship between doctors and their patients. A doctor can have many patients, but each patient can have only one doctor.

# Technologies Used
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Setup
# Prerequisites
#### Before you can run this application, you need to have the following installed on your computer:

- Java 8 or higher
- MySQL

# Getting Started
#### To get started with this application, follow these steps:

1. Clone this repository to your local machine.
2. Open the project in your favorite IDE (such as IntelliJ IDEA or Eclipse).
3. Open the application.properties file located in src/main/resources and set the MySQL database username and password.
4. Run the application.

# API Documentation
#### Once the application is running, you can access the following APIs:

## Doctor APIs
- `GET /doctors` - Returns a list of all doctors
- `POST /doctors` - Creates a new doctor
- `GET /doctors/{id}` - Returns the doctor with the specified ID
- `DELETE /doctors/{id}` - Deletes the doctor with the specified ID

## Patient APIs
- `GET /patients` - Returns a list of all patients
- `POST /patients` - Creates a new patient
- `GET /patients/{id}` - Returns the patient with the specified ID
- `DELETE /patients/{id}` - Deletes the patient with the specified 

# Project Summary
##### The Spring Boot project on Doctor and Patient Management System demonstrates how to manage a Many-to-One relationship between doctors and their patients using Spring Data JPA. The project includes the following components: model, service, layer, and repository. The project uses MySQL as a database and Maven as a build tool. The project provides API endpoints to perform CRUD operations on doctors and patients. The project is well-structured and easy to understand, making it a good starting point for developing more complex Spring Boot applications.
