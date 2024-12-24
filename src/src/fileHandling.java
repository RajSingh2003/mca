import java.io.*;
import java.util.Scanner;
public class fileHandling
{
public static void main(String[] args)
{
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the file path: ");
String filePath = scanner.nextLine();
try {
FileReader fileReader = new FileReader(filePath);
BufferedReader bufferedReader = new BufferedReader(fileReader);
String line;
System.out.println("File contents:");
while ((line = bufferedReader.readLine()) != null)
{
System.out.println(line);
}
bufferedReader.close();
fileReader.close();
}
catch (FileNotFoundException e)
{
System.out.println("Error: The file '" + filePath + "' was not found.");
}
catch (IOException e)
{
System.out.println("Error: An I/O error occurred while reading the file.");
}
finally
{
scanner.close();
}
}
}