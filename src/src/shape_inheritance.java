class BankAccount {
 protected String accountNumber;
 protected double balance;
 // Constructor
 public BankAccount(String accountNumber, double initialBalance) {
 this.accountNumber = accountNumber;
 this.balance = initialBalance;
 }
 // Deposit method
 public void deposit(double amount) {
 if (amount > 0) {
 balance += amount;
 System.out.println("Deposited " + amount + ". New balance: " + balance);
 } else {
 System.out.println("Deposit amount must be positive.");
 }
 }
 // Withdraw method
 public void withdraw(double amount) {
 if (amount > 0 && balance >= amount) {
 balance -= amount;
 System.out.println("Withdrew " + amount + ". New balance: " + balance);
 } else {
 System.out.println("Invalid withdrawal amount or insufficient balance.");
 }
 }
 // Abstract method for displaying account details (to be overridden by subclasses)
 public void displayAccountDetails() {
 System.out.println("Account Number: " + accountNumber);
 System.out.println("Balance: " + balance);
 }
}
// Subclass: CurrentAccount
 class CurrentAccount extends BankAccount {
 private double overdraftLimit;
 // Constructor
 public CurrentAccount(String accountNumber, double initialBalance, double 
overdraftLimit) {
 super(accountNumber, initialBalance);
 this.overdraftLimit = overdraftLimit;
 }
 // Override to display account details for CurrentAccount
 @Override
 public void displayAccountDetails() {
 super.displayAccountDetails();
 System.out.println("Account Type: Current");
 System.out.println("Overdraft Limit: " + overdraftLimit);
 }
 // Method to withdraw money considering overdraft limit
 @Override
 public void withdraw(double amount) {
 if (amount > 0 && (balance - amount) >= -overdraftLimit) {
 balance -= amount;
 System.out.println("Withdrew " + amount + ". New balance: " + balance);
 } else {
 System.out.println("Invalid withdrawal amount or overdraft limit exceeded.");
 }
 }
}
// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
 private double interestRate;
 // Constructor
 public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
 super(accountNumber, initialBalance);
 this.interestRate = interestRate;
 }
 @Override
 public void displayAccountDetails() {
 super.displayAccountDetails();
 System.out.println("Account Type: Savings");
 System.out.println("Interest Rate: " + interestRate + "%");
 }
 public void applyInterest() {
 double interest = balance * interestRate / 100;
 balance += interest;
 System.out.println("Applied interest: " + interest + ". New balance: " + balance);
 }
}
public class shape_inheritance {
 public static void main(String[] args) {
 BankAccount savings = new SavingsAccount("SA123", 1000, 5);
 BankAccount current = new CurrentAccount("CA456", 500, 1000);
 savings.deposit(200);
 savings.withdraw(100);
 ((SavingsAccount) savings).applyInterest();
 savings.displayAccountDetails();
 current.deposit(300);
 current.withdraw(800);
 current.displayAccountDetails();
 }
}