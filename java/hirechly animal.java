package projct;

//Base class: Animal
class Animal {
 // Properties of the Animal class
 String name;
 int age;

 // Constructor to initialize the properties
 public Animal(String name, int age) {
     this.name = name;
     this.age = age;
 }

 // Method to return the sound the animal makes
 public String sound() {
     return "Some generic animal sound";
 }

 // Getter methods for name and age
 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }
}

//Subclass: Dog that extends Animal
class Dog extends Animal {

 // Constructor to initialize Dog's name and age
 public Dog(String name, int age) {
     super(name, age);  // Calling the parent class constructor
 }

 // Overriding the sound method
 @Override
 public String sound() {
     return "Bark";
 }
}

//Subclass: Cat that extends Animal
class Cat extends Animal {

 // Constructor to initialize Cat's name and age
 public Cat(String name, int age) {
     super(name, age);  // Calling the parent class constructor
 }

 // Overriding the sound method
 @Override
 public String sound() {
     return "Meow";
 }
}

//Main class to run the program
public class pract3 {
 public static void main(String[] args) {
     // Creating instances of Dog and Cat
     Animal dog = new Dog("Buddy", 3);
     Animal cat = new Cat("Whiskers", 2);

     // Displaying the sounds made by the animals
     System.out.println(dog.getName() + " makes a sound: " + dog.sound());
     System.out.println(cat.getName() + " makes a sound: " + cat.sound());

     // Displaying age of each animal
     System.out.println(dog.getName() + " is " + dog.getAge() + " years old.");
     System.out.println(cat.getName() + " is " + cat.getAge() + " years old.");
 }
}

