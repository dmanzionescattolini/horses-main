# Car REST API Documentation

This is a README file for the Car REST API, which is built using Spring Boot, Maven, Spring Data JPA, Hibernate, Spring Security, and MySQL database. This API allows you to manage and interact with information related to cars, such as creating, reading, updating, and deleting car records.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Configuration](#configuration)
- [Endpoints](#endpoints)
- [Authentication](#authentication)
- [Error Handling](#error-handling)
- [Database Schema](#database-schema)
- [Testing](#testing)
- [Deployment](#deployment)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) 17 or higher installed.
- [Maven](https://maven.apache.org/) for building the project.
- [MySQL](https://www.mysql.com/) database server installed and running.
- [Spring Tool Suite (STS)] or any Java IDE of your choice.

## Getting Started

1. Clone this repository to your local machine:

   ```shell
   git clone < https://github.com/AH82021/horses.git >
   ```

2. Navigate to the project directory:

   ```shell
   cd horses
   ```

3. Build and run the application using Maven:

   ```shell
   mvn spring-boot:run
   ```

The API should now be running locally at `http://localhost:8080`.

### Configuration

To configure the application, you can modify the `application.properties` or `application.yml` file in the `src/main/resources` directory. Here are some common configurations you might want to adjust:

- Database configuration (URL, username, password, etc.)
- Security settings (JWT configuration, role-based access)
- Server port and context path

## Endpoints

The API provides the following endpoints for managing car records:

- `GET /api/cars`: Get a list of all cars.
- `GET /api/cars/{id}`: Get details of a specific car by ID.
- `POST /api/cars`: Create a new car record.
- `PUT /api/cars/{id}`: Update an existing car record by ID.
- `DELETE /api/cars/{id}`: Delete a car record by ID.

These endpoints can be accessed using HTTP methods and are secured by Spring Security.

## Authentication

This API is secured using Spring Security. Authentication is based on JSON Web Tokens (JWT). To access the protected endpoints, you need to obtain a JWT token. To get a token, make a POST request to `/api/authenticate` with your username and password in the request body. This will return a JWT token that you should include in the `Authorization` header of your requests as follows:

```
Authorization: Bearer <your-token>
```

## Error Handling

The API provides detailed error responses with appropriate HTTP status codes. When an error occurs, you will receive a JSON response with details about the error, including a status code and a message.

## Database Schema

The API uses a MySQL database to store car records. The database schema includes the following tables:

- `car`: Represents car records with attributes like `id`, `make`, `model`, `year`, `color`, etc.

You can find the database schema in the `src/main/resources/db/migration` directory using Liquibase migration scripts.

## Testing

The project includes unit and integration tests. To run the tests, use the following command:

```shell
mvn test
```

## Deployment

To deploy this API in a production environment, follow these steps:

1. Build the application with Maven:

   ```shell
   mvn clean install
   ```

2. Deploy the generated JAR file to your desired production environment.

3. Configure production-specific settings in the `application.properties` or `application.yml` file.

4. Set up a production-ready database and configure the connection settings.

5. Secure the application properly for production by following best practices, such as using HTTPS and proper firewall rules.

## Contributing

If you want to contribute to this project, please follow the standard guidelines for open-source contributions. Fork the repository, create a new branch for your changes, and submit a pull request with a clear description of your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.