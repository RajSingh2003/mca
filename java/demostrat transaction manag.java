package projct;


CREATE DATABASE bank_db;

USE bank_db;

CREATE TABLE bank_account (
    account_id INT PRIMARY KEY,
    account_name VARCHAR(100),
    balance DECIMAL(10, 2)
);

INSERT INTO bank_account (account_id, account_name, balance) VALUES
(1, 'Alice', 1000.00),
(2, 'Bob', 500.00);



public class TransactionDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/bank_db";
    private static final String USERNAME = "root"; // Update with your database username
    private static final String PASSWORD = "";     // Update with your database password

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Establish database connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");

            // Disable auto-commit for transaction management
            connection.setAutoCommit(false);

            // Perform fund transfer
            transferFunds(connection, 1, 2, 200.00); // Transfer $200 from Alice to Bob

            // Commit transaction
            connection.commit();
            System.out.println("Transaction committed successfully.");

        } catch (Exception e) {
            System.err.println("Transaction failed. Rolling back.");
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Error during rollback: " + rollbackEx.getMessage());
            }
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Restore default behavior
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error closing connection: " + ex.getMessage());
            }
        }
    }

    private static void transferFunds(Connection connection, int fromAccount, int toAccount, double amount) throws SQLException {
        String debitSQL = "UPDATE bank_account SET balance = balance - ? WHERE account_id = ?";
        String creditSQL = "UPDATE bank_account SET balance = balance + ? WHERE account_id = ?";

        try (
            PreparedStatement debitStmt = connection.prepareStatement(debitSQL);
            PreparedStatement creditStmt = connection.prepareStatement(creditSQL)
        ) {
            // Debit operation
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccount);
            int rowsUpdatedDebit = debitStmt.executeUpdate();

            if (rowsUpdatedDebit != 1) {
                throw new SQLException("Failed to debit the account. Account ID: " + fromAccount);
            }

            // Simulate a failure scenario (uncomment to test rollback)
            // if (true) throw new SQLException("Simulated failure after debit operation.");

            // Credit operation
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccount);
            int rowsUpdatedCredit = creditStmt.executeUpdate();

            if (rowsUpdatedCredit != 1) {
                throw new SQLException("Failed to credit the account. Account ID: " + toAccount);
            }

            System.out.println("Fund transfer completed: $" + amount + " transferred from Account " + fromAccount + " to Account " + toAccount);
        }
    }
}
