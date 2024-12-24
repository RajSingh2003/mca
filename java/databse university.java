package projct;

CREATE DATABASE University;

USE University;

CREATE TABLE student (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    grade VARCHAR(10)
);


DELIMITER $$

CREATE PROCEDURE getStudentById(IN input_id INT)
BEGIN
    SELECT student_id, name, age, grade
    FROM student
    WHERE student_id = input_id;
END$$

DELIMITER ;


INSERT INTO student (name, age, grade) VALUES
('Alice', 20, 'A'),
('Bob', 22, 'B'),
('Charlie', 19, 'C');



import java.sql.*;
import java.util.Scanner;

public class UniversityApp {

    // JDBC URL, username, password
    private static final String URL = "jdbc:mysql://localhost:3306/University";
    private static final String USERNAME = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "";     // Replace with your MySQL password

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("Connected to the University database.");

            // Prompt user for student ID
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student ID: ");
            int studentId = scanner.nextInt();

            // Invoke the stored procedure
            getStudentById(connection, studentId);

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void getStudentById(Connection connection, int studentId) {
        String procedureCall = "{CALL getStudentById(?)}";

        try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
            // Set the input parameter for the stored procedure
            callableStatement.setInt(1, studentId);

            // Execute the stored procedure
            ResultSet resultSet = callableStatement.executeQuery();

            // Display the student details
            if (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");

                System.out.println("Student Details:");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Grade: " + grade);
            } else {
                System.out.println("No student found with ID: " + studentId);
            }
        } catch (SQLException e) {
            System.err.println("Error while executing the stored procedure: " + e.getMessage());
        }
    }
}
