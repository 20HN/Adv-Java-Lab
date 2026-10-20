# Conversion of HTML into JSP

## Overview
This practical converts an existing HTML student-information form into a JSP page and demonstrates how a Servlet passes submitted data to a JSP result page.

## Learning Objectives
- Understand JavaServer Pages (JSP) and their purpose
- Learn JSP architecture and lifecycle
- Compare Servlet and JSP roles
- Use JSP directives and Expression Language (EL)
- Forward data from a Servlet to JSP
- Understand JSP as the presentation layer in MVC

## Main Concepts
- **JSP**: Server-side technology for dynamic web pages, combining HTML with JSP features.
- **Servlet**: Commonly handles request processing and controller logic.
- **JSP**: Commonly handles presentation/view logic.
- **Expression Language (EL)**: Displays values such as `${name}` and `${student.email}`.
- **JSP lifecycle**: Translation, compilation, class loading, instantiation, `jspInit()`, `_jspService()`, and `jspDestroy()`.

## Practical Flow
1. Rename the original HTML form to `student.jsp`.
2. Add a JSP page directive:
   ```jsp
   <%@ page contentType="text/html;charset=UTF-8" %>
   ```
3. The form submits name, email, course, and age to the Servlet mapped to `/hello`.
4. The Servlet reads the values using `request.getParameter(...)`.
5. It stores them with `request.setAttribute(...)`.
6. It forwards the request to `result.jsp`.
7. The result page displays the values using EL, for example `${name}`.

## Example Structure
```text
servlet/
├── pom.xml
└── src/main/
    ├── java/com/servlet/HelloServlet.java
    └── webapp/
        ├── student.jsp
        └── result.jsp
```

## Build and Deploy
From the directory containing `pom.xml`:
```bash
mvn package
```
Deploy the generated WAR to the configured Tomcat server and open the application URL. The exact WAR filename depends on the Maven configuration.

## Notes
- The practical uses Jakarta Servlet imports for Tomcat 11.
- JSP is translated into a Servlet by the JSP container before execution.
- The source document introduces scriptlets for syllabus understanding, while recommending EL/JSTL and Java-side components for presentation logic in modern applications.
