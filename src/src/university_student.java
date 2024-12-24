/*
 * CREATE DATABASE Spring;


USE Spring;

CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    balance DECIMAL(10, 2) NOT NULL
);


INSERT INTO accounts (account_id, balance) VALUES (1, 500.00);
INSERT INTO accounts (account_id, balance) VALUES (2, 300.00);

 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class university_student {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Spring";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "user";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            withdraw(connection, 1, 100);
            deposit(connection, 2, 100);

            connection.commit();
            System.out.println("Transaction committed successfully.");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to an error: " + e.getMessage());
                } catch (SQLException rollbackEx) {
                    System.err.println("Error during rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error closing connection: " + closeEx.getMessage());
                }
            }
        }
    }

    private static void withdraw(Connection connection, int accountId, double amount) throws SQLException {
        String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(withdrawSQL)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Withdrawal failed, account not found: " + accountId);
            }
        }
    }

    private static void deposit(Connection connection, int accountId, double amount) throws SQLException {
        String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(depositSQL)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Deposit failed, account not found: " + accountId);
            }
        }
    }
}
