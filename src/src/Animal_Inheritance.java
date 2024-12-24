class Animal
{
 protected String name;
 protected int age;
 public Animal(String name, int age)
 {
 this.name = name;
 this.age = age;
 }
 public String sound()
 {
 return "Some generic animal sound";
 }
 public String getName()
 {
 return name;
 }
 public int getAge()
 {
 return age;
 }
 public void displayInfo()
 {
 System.out.println("Animal Name: " + name);
 System.out.println("Animal Age: " + age);
 System.out.println("Animal Sound: " + sound());
 }
}
class Cat extends Animal
{
 public Cat(String name, int age)
 {
 super(name, age);
 }
 @Override
 public String sound()
 {
 return "Meow";
 }
}
class Dog extends Animal
{
 public Dog(String name, int age)
 {
 super(name, age);
 }
 public String sound()
 {
 return "Bark";
 }
}
public class Animal_Inheritance
{
 public static void main(String[] args)
 {
 Animal dog = new Dog("Buddy", 3);
 Animal cat = new Cat("Whiskers", 2);
 System.out.println("Dog Info:");
 dog.displayInfo();
 System.out.println();
 System.out.println("Cat Info:");
 cat.displayInfo();
 }
}