package projct;

import java.util.Scanner;

//Base class: Shape
abstract class Shape {
 // Abstract method to calculate the area of the shape
 public abstract double area();
}

//Subclass: Circle that extends Shape
class Circle extends Shape {
 private double radius;

 // Constructor to initialize the radius of the circle
 public Circle(double radius) {
     this.radius = radius;
 }

 // Overriding the area method for Circle
 @Override
 public double area() {
     return Math.PI * radius * radius;  // Area of a circle: π * r^2
 }
}

//Subclass: Rectangle that extends Shape
class Rectangle extends Shape {
 private double length;
 private double width;

 // Constructor to initialize the dimensions of the rectangle
 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 // Overriding the area method for Rectangle
 @Override
 public double area() {
     return length * width;  // Area of a rectangle: length * width
 }
}

//Main class to test the implementation
public class pract5 {
 public static void main(String[] args) {
     // Create a Scanner object to take user input
     Scanner scanner = new Scanner(System.in);

     // Get user input for the type of shape
     System.out.println("Enter the type of shape (1 for Circle, 2 for Rectangle): ");
     int shapeType = scanner.nextInt();

     // Create a shape based on user input
     Shape shape = null;

     if (shapeType == 1) {
         // Get user input for Circle dimensions
         System.out.print("Enter the radius of the circle: ");
         double radius = scanner.nextDouble();
         shape = new Circle(radius);  // Create Circle object
     } else if (shapeType == 2) {
         // Get user input for Rectangle dimensions
         System.out.print("Enter the length of the rectangle: ");
         double length = scanner.nextDouble();
         System.out.print("Enter the width of the rectangle: ");
         double width = scanner.nextDouble();
         shape = new Rectangle(length, width);  // Create Rectangle object
     } else {
         System.out.println("Invalid shape type.");
         scanner.close();
         return; // Exit if the shape type is invalid
     }

     // Calculate and display the area of the shape
     System.out.println("The area of the shape is: " + shape.area());

     // Close the scanner object
     scanner.close();
 }
}

