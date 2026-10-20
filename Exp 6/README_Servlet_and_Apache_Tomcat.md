# Java Servlets, Apache Tomcat, and Basic Web Applications

This README combines the two practicals **“Java Servlet / Jakarta Servlet”** and **“Introduction to Apache Tomcat & Basic Web Application”**, as requested.

## Overview
Apache Tomcat is a web server and Servlet container used to serve web applications and run Java Servlets. The basic web-app practical creates a static HTML page; the Servlet practical builds on that foundation to process HTTP requests and generate dynamic responses.

## Requirements
- Java JDK
- Apache Tomcat (the source practical refers to Tomcat 11)
- Text editor or IDE
- Maven for the Servlet project shown in the source document
- Browser

## Part 1: Apache Tomcat and a Basic Web Application

### Important Directories
- `bin`: startup and shutdown scripts
- `conf`: configuration files
- `lib`: Tomcat libraries
- `logs`: log files
- `webapps`: default application deployment directory
- `temp` and `work`: runtime-related directories

### Create a Static Web App
Create this structure under Tomcat's `webapps` directory:
```text
webapps/
└── MyWebApp/
    └── index.html
```

Example `index.html`:
```html
<!DOCTYPE html>
<html>
<head>
  <title>My Web Application</title>
</head>
<body>
  <h1>Welcome to My Web Application</h1>
  <p>This application is running on Apache Tomcat.</p>
</body>
</html>
```

### Start and Test Tomcat
1. Open the Tomcat `bin` directory.
2. On Windows, run `startup.bat` (PowerShell: `.\startup.bat`).
3. Open:
   `http://localhost:8080/MyWebApp/`
4. Confirm that the HTML welcome page appears.

The folder name under `webapps` becomes the context path in the URL. In this practical, the configured port is `8080`.

## Part 2: Java Servlet

### What Is a Servlet?
A Servlet is a Java class that runs inside a Servlet container and handles client requests, commonly HTTP requests, to create dynamic responses.

### Request–Response Flow
```text
Browser
  -> HTTP request
  -> Apache Tomcat / Servlet container
  -> Servlet processing
  -> HTTP response
  -> Browser
```

### Topics Covered
- HTTP and Servlet API
- `GET` handled by `doGet()` and `POST` handled by `doPost()`
- Servlet lifecycle: loading, instantiation, `init()`, request servicing, and `destroy()`
- `HttpServletRequest` and `HttpServletResponse`
- `ServletConfig` and `ServletContext`
- Cookies and `HttpSession`
- Servlet listeners/events
- Filters and `FilterChain`

### Example URL Mapping
The source practical uses:
```java
@WebServlet("/hello")
```
For an application deployed with context path `servlet`, the example URL is:
`http://localhost:8080/servlet/hello`

- `localhost`: this computer
- `8080`: Tomcat port in the practical
- `servlet`: application context path
- `hello`: Servlet URL mapping

### Maven Configuration
The source practical specifies WAR packaging and the Jakarta Servlet API:
```xml
<packaging>war</packaging>

<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.1.0</version>
    <scope>provided</scope>
</dependency>
```
The `provided` scope indicates that Tomcat supplies the Servlet API at runtime.

### Example Project Structure
```text
servlet/
├── pom.xml
└── src/
    └── main/
        ├── java/com/servlet/
        │   ├── HelloServlet.java
        │   ├── LoginServlet.java
        │   ├── HomeServlet.java
        │   ├── AuthFilter.java
        │   └── AppListener.java
        └── webapp/
            └── index.html
```

### Build and Deploy
1. Open a terminal in the directory containing `pom.xml`.
2. Build the WAR:
   ```bash
   mvn package
   ```
3. Locate the generated WAR under `target/`.
4. Copy the WAR into Tomcat's `webapps` directory, or use your configured deployment workflow.
5. Start/restart Tomcat if needed and open the URL using the deployed WAR's context path.

For example, if the deployed WAR is named `servlet.war`, its context path is commonly `/servlet`, so the URL for the mapped servlet is:
`http://localhost:8080/servlet/hello`

## Troubleshooting
- **404 Not Found**: Check that Tomcat is running, the application deployed successfully, the context path matches the WAR/folder name, and the Servlet mapping is correct.
- **Tomcat will not start**: Verify Java configuration and check the Tomcat logs.
- **Port already in use**: Another process may be using port 8080.
- **Servlet API compilation errors**: Ensure the project uses the Jakarta imports appropriate to the Tomcat version used in the practical.
- **MyWebApp URL fails**: Verify `webapps/MyWebApp/index.html` exists and the URL is exactly `http://localhost:8080/MyWebApp/`.

## Related Practical
The separate HTML-to-JSP practical converts an HTML page to JSP, passes submitted form data through a Servlet, and displays the result with JSP Expression Language. It is not merged into this README because only the Servlet and Tomcat introduction files were requested as one.
