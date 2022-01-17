This is a Spring-Boot application with in-memory DB (H2). Basic dependencies are added in POM.xml including hibernate for database operations.

# Problem Statement
Implement a CRUD interface for a User Management System.

A user has the following properties:
  - First Name
  - Last Name
  - Email

The system should provide following interfaces:
  - Retrieve a list of users
    - /v1/users
  - Retrieve a specific user
    - /v1/users/{user_id}
  - Search for users.  A user is considered a match if the provided keyword appears in first or last names of the user.
    - /v1/users/q?name={search text}
  - Add a user
      - /v1/users
  - Update a specific user
    - /v1/users/{user_id}

# NOTES
  - Request/Response interfaces are intentionally left out for engineers to determine
  - No need to add authentication for this prototype
  - A simple in memory database is included as part of the code template. Please see below instructions for Database.

# Database
## Table Name : USER_DETAILS
| Column Name   | Datatype      | Description                 |
| ------------- | ------------- | --------------------------- |
| USER_ID       | INT           | Primary key (Autoincrement) |
| FIRST_NAME    | VARCHAR(250)  | First name                  |
| LAST_NAME     | VARCHAR(250)  | Last name                   |
| EMAIL         | VARCHAR(250)  | Email address               |

## How to Access H2-Console
### URL : http://localhost:8080/h2

1. Please make sure to add an empty file named "test.mv.db" under /Users/{username}
2. Once you open the H2 console using above URL, you should see something like following
   ![Alt text](H2-Console.png?raw=true "H2 Console")
3. Make sure JDBC URL is "jdbc:h2:mem:testdb"
4. Password is not required
5. Click on "Connect" and it should take you to th schema view where USER_DETAILS table is already loaded with few data.
   ![Alt text](USER_DETAILS_Schema.png?raw=true "USER_DETAILS Schema View")

# Submission
1. Please fork the repo and create a PR.
2. Also, please help share the postman collection for APIs 


