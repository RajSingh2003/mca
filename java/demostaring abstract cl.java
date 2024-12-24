package projct;

//Interface for deposit operation
interface Deposit {
 void deposit(double amount);
}

//Interface for withdraw operation
interface Withdraw {
 void withdraw(double amount);
}

//Interface for calculating interest
interface CalculateInterest {
 double calculateInterest();
}

//Abstract class: Account
abstract class Account {
 protected String accountNumber;
 protected double balance;

 // Constructor to initialize account number and balance
 public Account(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 // Abstract method to display account details
 public abstract void displayAccountDetails();
}

//Subclass: SavingsAccount that extends Account and implements interfaces
class SavingsAccount extends Account implements Deposit, Withdraw, CalculateInterest {
 private double interestRate;

 // Constructor to initialize savings account with interest rate
 public SavingsAccount(String accountNumber, double balance, double interestRate) {
     super(accountNumber, balance);
     this.interestRate = interestRate;
 }

 // Implementing deposit method
 @Override
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 // Implementing withdraw method
 @Override
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrew: " + amount);
     } else {
         System.out.println("Invalid withdrawal amount or insufficient balance.");
     }
 }

 // Implementing calculateInterest method
 @Override
 public double calculateInterest() {
     return balance * (interestRate / 100);
 }

 // Implementing abstract method to display account details
 @Override
 public void displayAccountDetails() {
     System.out.println("Savings Account Details:");
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: " + balance);
     System.out.println("Interest Rate: " + interestRate + "%");
     System.out.println("Interest: " + calculateInterest());
 }
}

//Subclass: CurrentAccount that extends Account and implements interfaces
class CurrentAccount extends Account implements Deposit, Withdraw {
 
 // Constructor to initialize current account
 public CurrentAccount(String accountNumber, double balance) {
     super(accountNumber, balance);
 }

 // Implementing deposit method
 @Override
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 // Implementing withdraw method
 @Override
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrew: " + amount);
     } else {
         System.out.println("Invalid withdrawal amount or insufficient balance.");
     }
 }

 // Implementing abstract method to display account details
 @Override
 public void displayAccountDetails() {
     System.out.println("Current Account Details:");
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: " + balance);
 }
}

//Main class to demonstrate the program
public class pract6 {
 public static void main(String[] args) {
     // Creating a SavingsAccount object
     Account savings = new SavingsAccount("S12345", 5000, 5.0);
     savings.deposit(1000);
     savings.withdraw(500);
     savings.displayAccountDetails();
     
     System.out.println();  // Line break for readability
     
     // Creating a CurrentAccount object
     Account current = new CurrentAccount("C98765", 2000);
     current.deposit(500);
     current.withdraw(300);
     current.displayAccountDetails();
 }
}

