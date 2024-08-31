# Shopping Application

## Overview

This project is a Shopping Application built using Spring Data JPA. The application is designed to manage an online store, providing functionalities such as browsing products, managing a shopping cart, placing orders, and handling customer data. The project follows a layered architecture, ensuring modularity and maintainability.

## Project Structure

The application is organized into the following packages:

- **DAO Package (`dao/`)**: Manages all database operations, including CRUD operations and custom queries. It provides an abstraction layer between the database and the business logic.

- **Entity Package (`entity/`)**: Contains the entity classes that map to the database tables. Each entity represents a specific aspect of the shopping application, such as products, customers, orders, and carts.

- **Config Package (`config/`)**: Handles the configuration of the application, including setting up the IOC container, configuring Beans, and managing environment-specific settings like DataSource and transaction management.

- **Service Package (`service/`)**: Implements the business logic of the application. It acts as a bridge between the DAO layer and the controllers, processing data and ensuring the correct application of business rules.

- **Repository Package (`repository/`)**: Contains repository interfaces that extend `JpaRepository`. These interfaces provide methods for interacting with the database, such as saving, retrieving, and querying data related to products, customers, and orders.

## Features

- **Product Management**: Add, view, update, and delete products in the store.
- **Customer Management**: Register, update, and manage customer information.
- **Shopping Cart**: Add products to the cart, view cart items, and manage quantities.
- **Order Processing**: Place orders, view order history, and manage order status.
- **Search and Filter**: Search for products and filter them by various criteria.

## Technologies Used

- **Spring Data JPA**: For data persistence and interaction with the database.
- **Hibernate**: As the JPA implementation for ORM (Object-Relational Mapping).
- **MySQL Database**: Used as an in-memory database for development and testing.
- **Maven**: For project build and dependency management.

## Setup and Installation

**Clone the Repository**:
```bash
git clone https://github.com/mofq786/Shopping_Application_Using_Spring-Data-JPA.git

cd Shopping_Application_Using_Spring-Data-JPA
```

## Contributing

Contributions are welcome! Please fork this repository, create a new branch, and submit a pull request for any features or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or inquiries, feel free to reach out via email: mofq9786@gmail.com
