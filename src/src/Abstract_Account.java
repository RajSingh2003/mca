abstract class Shape 
{ 
public abstract double area(); 
} 
class Circle extends Shape 
{ 
private double radius; 
public Circle(double radius) 
{ 
this.radius = radius; 
} 
  
public double area() 
{ 
return Math.PI * radius * radius; 
} 
} 
class Rectangle extends Shape 
{ 
private double width; 
private double height; 
public Rectangle(double width, double height) 
{ 
this.width = width; 
this.height = height; 
} 
@Override 
public double area() 
{ 
return width * height; 
} 
} 
public class Abstract_Account 
{ 
public static void main(String[] args) 
{ 
Shape circle = new Circle(5.0); 
Shape rectangle = new Rectangle(4.0, 6.0); 
System.out.println("Area of Circle: " + circle.area()); 
System.out.println("Area of Rectangle: " + rectangle.area()); 
} 
}