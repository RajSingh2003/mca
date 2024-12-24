package projct;

import java.io.*;
import java.util.Scanner;

public class pract2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine(); // Read the file path from the user

        // Try to read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("File content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The specified file was not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred while reading the file.");
        } finally {
            scanner.close();
        }
    }
}
