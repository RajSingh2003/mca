/*
 *create database
 * create database school 
 * 
 * use database
 * use school
 */
import java.sql.*;
import java.util.Scanner;
public class CRUD_student_database {
 private static final String DB_URL = "jdbc:mysql://localhost:3306/school";
 private static final String DB_USER = "root";
 private static final String DB_PASSWORD = "user";
 public static void main(String[] args) {
 try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, 
DB_PASSWORD)) {
 System.out.println("Connected to the database.");
 createTable(connection);
 Scanner scanner = new Scanner(System.in);
 while (true) {
 System.out.println("\n--- Student Database CRUD Operations ---");
 System.out.println("1. Insert Student");
 System.out.println("2. Display All Students");
 System.out.println("3. Update Student");
 System.out.println("4. Delete Student");
 System.out.println("5. Exit");
 System.out.print("Enter your choice: ");
 int choice = scanner.nextInt();
 switch (choice) {
 case 1 -> insertStudent(connection, scanner);
 case 2 -> displayStudents(connection);
 case 3 -> updateStudent(connection, scanner);
 case 4 -> deleteStudent(connection, scanner);
 case 5 -> {
 System.out.println("Exiting...");
 scanner.close();
 return;
 }
 default -> System.out.println("Invalid choice. Try again.");
 }
 }
 } catch (SQLException e) {
 System.out.println("Database error: " + e.getMessage());
 }
 }
 private static void createTable(Connection connection) throws SQLException {
 String createTableSQL = """
 CREATE TABLE IF NOT EXISTS student (
 student_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(50),
 age INT,
 grade VARCHAR(10)
 );
 """;
 try (Statement statement = connection.createStatement()) {
 statement.execute(createTableSQL);
 System.out.println("Student table is ready.");
 }
 }
 private static void insertStudent(Connection connection, Scanner scanner) throws 
SQLException {
 System.out.print("Enter student name: ");
 String name = scanner.next();
 System.out.print("Enter student age: ");
 int age = scanner.nextInt();
 System.out.print("Enter student grade: ");
 String grade = scanner.next();
 String insertSQL = "INSERT INTO student (name, age, grade) VALUES (?, ?, ?)";
 try (PreparedStatement preparedStatement = 
connection.prepareStatement(insertSQL)) {
 preparedStatement.setString(1, name);
 preparedStatement.setInt(2, age);
 preparedStatement.setString(3, grade);
 int rowsInserted = preparedStatement.executeUpdate();
 System.out.println(rowsInserted + " student(s) added.");
 }
 }
 private static void displayStudents(Connection connection) throws SQLException {
 String selectSQL = "SELECT * FROM student";
 try (Statement statement = connection.createStatement();
 ResultSet resultSet = statement.executeQuery(selectSQL)) {
 System.out.println("\n--- Student Records ---");
 while (resultSet.next()) {
 System.out.printf("ID: %d, Name: %s, Age: %d, Grade: %s%n",
 resultSet.getInt("student_id"),
 resultSet.getString("name"),
 resultSet.getInt("age"),
 resultSet.getString("grade"));
 }
 }
 }
 private static void updateStudent(Connection connection, Scanner scanner) throws 
SQLException {
 System.out.print("Enter student ID to update: ");
 int id = scanner.nextInt();
 System.out.print("Enter new name: ");
 String name = scanner.next();
 System.out.print("Enter new age: ");
 int age = scanner.nextInt();
 System.out.print("Enter new grade: ");
 String grade = scanner.next();
 String updateSQL = "UPDATE student SET name = ?, age = ?, grade = ? WHERE 
student_id = ?";
 try (PreparedStatement preparedStatement = 
connection.prepareStatement(updateSQL)) {
 preparedStatement.setString(1, name);
 preparedStatement.setInt(2, age);
 preparedStatement.setString(3, grade);
 preparedStatement.setInt(4, id);
 int rowsUpdated = preparedStatement.executeUpdate();
 System.out.println(rowsUpdated + " student(s) updated.");
 }
 }
 private static void deleteStudent(Connection connection, Scanner scanner) throws 
SQLException {
 System.out.print("Enter student ID to delete: ");
 int id = scanner.nextInt();
 String deleteSQL = "DELETE FROM student WHERE student_id = ?";
 try (PreparedStatement preparedStatement = 
connection.prepareStatement(deleteSQL)) {
 preparedStatement.setInt(1, id);
 int rowsDeleted = preparedStatement.executeUpdate();
 System.out.println(rowsDeleted + " student(s) deleted.");
 }
 }
}