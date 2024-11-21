# **Video Service with GraphQL**

A Spring Boot project implementing a video service using GraphQL for querying and managing data about videos and their creators. This repository is designed to serve as a learning tool for implementing GraphQL in a Spring Boot application.

---

## **Table of Contents**

1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Getting Started](#getting-started)
4. [Project Structure](#project-structure)
5. [GraphQL API](#graphql-api)
6. [GraphQL Testing](#graphql-testing)
7. [Contributing](#contributing)
8. [License](#license)

---

## **Features**

- **GraphQL API**:
  - Query videos and their creators.
  - Fetch specific creators by ID.
- **Database**:
  - Uses an in-memory H2 database.
  - Automatically seeded with sample data for videos and creators.
- **GraphiQL Playground**:
  - Interactive interface to test GraphQL queries.
- **Spring Boot Integration**:
  - Fully integrated with Spring Boot and Spring Data JPA.

---

## **Technologies Used**

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database**
- **Spring for GraphQL**
- **Lombok**

---

## **Getting Started**

### Prerequisites

- Java 17 or higher
- Maven
- IDE (e.g., IntelliJ, Eclipse)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/LahcenEzzara/video-service.git
   cd video-service
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**:
   - **GraphiQL Interface**: [http://localhost:8090/graphiql](http://localhost:8090/graphiql)
   - **H2 Console**: [http://localhost:8090/h2-console](http://localhost:8090/h2-console)
     - JDBC URL: `jdbc:h2:mem:video-db`
     - Username: `sa`
     - Password: *empty*

---

## **Project Structure**

```
src/main/java/ma/xproce/inventoryservice
│
├── entities
│   ├── Creator.java    # Entity for Creator
│   └── Video.java      # Entity for Video
│
├── repositories
│   ├── CreatorRepository.java    # JPA Repository for Creator
│   └── VideoRepository.java      # JPA Repository for Video
│
├── web
│   └── VideoGraphQlController.java    # GraphQL Controller
│
└── InventoryServiceApplication.java    # Main application class
```

---

## **GraphQL API**

### **Schemas**

#### `Queries.graphqls`
```graphql
type Query {
    videoList: [Video]
    creatorById(id: Float): Creator
}
```

#### `Video.graphqls`
```graphql
type Video {
    id: Float
    name: String
    url: String
    description: String
    datePublication: String
    creator: Creator
}
```

#### `Creator.graphqls`
```graphql
type Creator {
    id: Float
    name: String
    email: String
}
```

### **Example Queries**

#### Fetch All Videos
```graphql
{
    videoList {
        id
        name
        url
        description
        datePublication
        creator {
            id
            name
        }
    }
}
```

#### Fetch Creator by ID
```graphql
{
    creatorById(id: 1) {
        id
        name
        email
    }
}
```

---

## **GraphQL Testing**

To test the GraphQL API, access the **GraphiQL interface** at the following URL:

[http://localhost:8090/graphiql](http://localhost:8090/graphiql)

Use the interface to run GraphQL queries, such as:

#### Example Query: Fetch All Videos
```graphql
{
    videoList {
        id
        name
        description
    }
}
```

#### Example Query: Fetch Creator by ID
```graphql
{
    creatorById(id: 1) {
        id
        name
        email
    }
}
```

---

## **Contributing**

Contributions are welcome! Feel free to open issues or submit pull requests.

### Steps to Contribute:
1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push to your forked repository.
5. Open a pull request.

---

## **License**

This project is licensed under the MIT License.