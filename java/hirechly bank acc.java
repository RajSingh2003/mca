package projct;

import java.util.Scanner;

//Base class: BankAccount
class BankAccount {
 // Properties of the BankAccount class
 String accountNumber;
 double balance;

 // Constructor to initialize the account number and balance
 public BankAccount(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 // Method to deposit money
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 // Method to withdraw money
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrew: " + amount);
     } else {
         System.out.println("Invalid withdrawal amount or insufficient balance.");
     }
 }

 // Method to display account details (to be overridden in subclasses)
 public void displayAccountDetails() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: " + balance);
 }
}

//Subclass: SavingsAccount that extends BankAccount
class SavingsAccount extends BankAccount {

 // Constructor to initialize SavingsAccount's account number and balance
 public SavingsAccount(String accountNumber, double balance) {
     super(accountNumber, balance); // Calling the parent class constructor
 }

 // Overriding the displayAccountDetails method for SavingsAccount
 @Override
 public void displayAccountDetails() {
     System.out.println("Savings Account Details:");
     super.displayAccountDetails(); // Calling the parent class display method
 }
}

//Subclass: CurrentAccount that extends BankAccount
class CurrentAccount extends BankAccount {

 // Constructor to initialize CurrentAccount's account number and balance
 public CurrentAccount(String accountNumber, double balance) {
     super(accountNumber, balance); // Calling the parent class constructor
 }

 // Overriding the displayAccountDetails method for CurrentAccount
 @Override
 public void displayAccountDetails() {
     System.out.println("Current Account Details:");
     super.displayAccountDetails(); // Calling the parent class display method
 }
}

//Main class to test the implementation
public class pract4 {
 public static void main(String[] args) {
     // Create a Scanner object to take user input
     Scanner scanner = new Scanner(System.in);

     // Get user input for the account type
     System.out.println("Enter account type (1 for Savings, 2 for Current): ");
     int accountType = scanner.nextInt();
     scanner.nextLine(); // consume the newline character

     // Get user input for the account number and initial balance
     System.out.println("Enter account number: ");
     String accountNumber = scanner.nextLine();

     System.out.println("Enter initial balance: ");
     double initialBalance = scanner.nextDouble();

     // Create the bank account based on the account type
     BankAccount account;
     if (accountType == 1) {
         account = new SavingsAccount(accountNumber, initialBalance);
     } else {
         account = new CurrentAccount(accountNumber, initialBalance);
     }

     // Perform deposit and withdrawal operations
     System.out.println("Enter amount to deposit: ");
     double depositAmount = scanner.nextDouble();
     account.deposit(depositAmount);

     System.out.println("Enter amount to withdraw: ");
     double withdrawAmount = scanner.nextDouble();
     account.withdraw(withdrawAmount);

     // Display account details
     account.displayAccountDetails();

     // Close the scanner object
     scanner.close();
 }
}

