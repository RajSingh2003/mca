//Q1
import java.util.Scanner;
public class zeroException
{
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
try {
System.out.print("Enter the first integer: ");
int num1 = getValidInteger(sc);
System.out.print("Enter the second integer: ");
int num2 = getValidInteger(sc);
if (num2 == 0)
{
System.out.println("Error: Cannot divide by zero.");
}
else
{
int result = num1 / num2;
System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
}
}
catch (Exception e)
{
System.out.println("Invalid input. \nPlease enter valid integers.");
}
finally
{
sc.close();
}
}
private static int getValidInteger(Scanner scanner)
{
while (!scanner.hasNextInt())
{
System.out.println("Invalid input. \nPlease enter a valid integer.");
scanner.next();
}
return scanner.nextInt();
}
}