
abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void displayAccountDetails();
}

interface Deposit {
    void deposit(double amount);
}

interface Withdraw {
    void withdraw(double amount);
}
interface InterestCalculable{
	 public void calculateInterest();
}
class SavingsAccounttt extends Account implements Deposit, Withdraw, InterestCalculable {
    private double interestRate;

    public SavingsAccounttt(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest calculated: " + interest + ". New balance: " + balance);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate * 100 + "%");
    }
}

class CurrentAccount extends Account implements Deposit, Withdraw {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount >= -overdraftLimit)) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded or invalid withdrawal amount.");
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Current Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

public class account_abstract {
    public static void main(String[] args) {
        SavingsAccounttt savings = new SavingsAccounttt("S123", 1000.0, 0.03);
        savings.displayAccountDetails();
        savings.deposit(500);
        savings.withdraw(200);
        savings.calculateInterest();
        savings.displayAccountDetails();
        
        System.out.println();
        
        CurrentAccount current = new CurrentAccount("C456", 2000.0, 1000.0);
        current.displayAccountDetails();
        current.deposit(1000);
        current.withdraw(2500);
        current.withdraw(4000);
    }
}
