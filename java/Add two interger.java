package projct;

import java.util.Scanner;

public class pract1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt user for first integer
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();

            // Prompt user for second integer
            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();

            // Perform division
            int result = num1 / num2;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
        } finally {
            scanner.close();
        }
    }
}


