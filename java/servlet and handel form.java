package projct;


from.html

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Submission</title>
</head>
<body>
    <h1>Submit Your Details</h1>
    <form action="FormHandler" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age"><br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/FormHandler")
public class FormHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Read form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        int age = (ageStr != null && !ageStr.isEmpty()) ? Integer.parseInt(ageStr) : -1;

        // Process data (basic validation example)
        String ageMessage = (age >= 0) ? "Your age is " + age : "Age not provided";

        // Generate response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Form Submission Result</h1>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>" + ageMessage + "</p>");
        out.println("</body></html>");
    }
}




web.xml

If you prefer XML configuration instead of @WebServlet, update web.xml in WebContent/WEB-INF:

<web-app xmlns="http://java.sun.com/xml/ns/javaee" version="3.0">
<servlet>
    <servlet-name>FormHandler</servlet-name>
    <servlet-class>FormHandler</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>FormHandler</servlet-name>
    <url-pattern>/FormHandler</url-pattern>
</servlet-mapping>
</web-app>




Go to Window > Preferences > Server > Runtime Environments.
Click Add, select Apache > Tomcat, and specify the installation directory.
Create a Dynamic Web Project:

In Eclipse, go to File > New > Dynamic Web Project.
Name the project (e.g., FormHandlerServlet) a


Create an HTML file (form.html) in the WebContent folder of your project:


