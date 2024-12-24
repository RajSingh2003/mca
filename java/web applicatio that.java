package projct;

login.jsp

Create a JSP file named login.jsp inside the WebContent folder:
	
	<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>Login</title>
	</head>
	<body>
	    <h2>Login</h2>
	    <form action="LoginServlet" method="post">
	        <label for="username">Username:</label>
	        <input type="text" id="username" name="username" required><br><br>

	        <label for="password">Password:</label>
	        <input type="password" id="password" name="password" required><br><br>

	        <button type="submit">Login</button>
	    </form>
	</body>
	</html>

	
	
	Create a servlet class called LoginServlet that handles user authentication. This servlet will validate the credentials and manage the session.
	
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	@WebServlet("/LoginServlet")
	public class LoginServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    // Predefined set of usernames and passwords (for demonstration purposes)
	    private static final String VALID_USERNAME = "user";
	    private static final String VALID_PASSWORD = "password";

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Retrieve the form parameters
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // Validate the credentials
	        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
	            // Authentication successful, create a session
	            HttpSession session = request.getSession();
	            session.setAttribute("username", username);

	            // Redirect to the welcome page
	            response.sendRedirect("welcome.jsp");
	        } else {
	            // Authentication failed, redirect to login page with an error message
	            response.sendRedirect("login.jsp?error=invalid");
	        }
	    }
	}

	
	
	
	Create a welcome.jsp page that is displayed after successful login:

		<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>Welcome</title>
	</head>
	<body>
	    <h2>Welcome, ${sessionScope.username}!</h2>
	    <p>You are successfully logged in.</p>
	    <a href="logout.jsp">Logout</a>
	</body>
	</html>

	
	Create a logout.jsp page that invalidates the session and logs out the user.
	
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>Logout</title>
	</head>
	<body>
	    <%
	        // Invalidate the session
	        session.invalidate();
	    %>
	    <h2>You have been logged out successfully.</h2>
	    <a href="login.jsp">Login again</a>
	</body>
	</html>


