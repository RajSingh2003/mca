package projct;

//Counter class with a synchronized method to increment the counter
class Counter {
 private int count = 0;

 // Synchronized method to ensure safe access to the shared counter
 public synchronized void increment() {
     count++;
 }

 // Getter method to get the current value of the counter
 public int getCount() {
     return count;
 }
}

//CounterThread class that runs the increment method 1000 times
class CounterThread extends Thread {
 private Counter counter;

 // Constructor to initialize the counter
 public CounterThread(Counter counter) {
     this.counter = counter;
 }

 @Override
 public void run() {
     // Increment the counter 1000 times
     for (int i = 0; i < 1000; i++) {
         counter.increment();
     }
 }
}

//Main class to demonstrate the multithreading behavior
public class pract9 {
 public static void main(String[] args) throws InterruptedException {
     // Create a shared Counter object
     Counter counter = new Counter();

     // Create three threads
     Thread thread1 = new CounterThread(counter);
     Thread thread2 = new CounterThread(counter);
     Thread thread3 = new CounterThread(counter);

     // Start the threads
     thread1.start();
     thread2.start();
     thread3.start();

     // Wait for all threads to finish
     thread1.join();
     thread2.join();
     thread3.join();

     // Print the final value of the counter
     System.out.println("Final counter value: " + counter.getCount());
 }
}
