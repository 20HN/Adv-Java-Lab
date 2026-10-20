# Java Database Connectivity (JDBC)

## Overview
This practical demonstrates connecting a Java application to a MySQL database using JDBC, inserting a student record, and reading records from a table.

## Requirements
- Java JDK
- MySQL Server
- Visual Studio Code with the Java Extension Pack, or another Java IDE
- MySQL Connector/J driver JAR

## Database Setup
Run these statements in MySQL:
```sql
CREATE DATABASE college;
USE college;

CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(30),
    branch VARCHAR(20)
);
```

## Driver and Connection
Add the MySQL Connector/J JAR to the project's referenced libraries. The example connection is:
```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/college",
    "root",
    "root"
);
```
Replace the username and password with the credentials configured on your machine. Do not commit real passwords to a public repository.

## Typical Workflow
1. Import `java.sql.*`.
2. Load the MySQL driver (`com.mysql.cj.jdbc.Driver`) if required by the setup.
3. Open a database connection with `DriverManager`.
4. Use a `PreparedStatement` to insert values into `student`.
5. Execute the insert with `executeUpdate()`.
6. Use a `Statement` and `executeQuery()` to retrieve rows.
7. Read returned data through `ResultSet`.
8. Close database resources.

## Example SQL
```sql
INSERT INTO student (id, name, branch)
VALUES (101, 'Rahul', 'CSE');

SELECT * FROM student;
```

## Important Notes
- `executeUpdate()` is used for statements such as INSERT, UPDATE, and DELETE; it returns the affected-row count.
- `executeQuery()` is used for SELECT statements and returns a `ResultSet`.
- Prefer try-with-resources in production code so connections and statements close reliably.
