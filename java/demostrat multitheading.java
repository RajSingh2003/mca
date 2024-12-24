package projct;

//Implementing the Runnable interface to print numbers
class PrintNumbers implements Runnable {
 private int start;
 private int end;

 // Constructor to initialize the start and end values for printing
 public PrintNumbers(int start, int end) {
     this.start = start;
     this.end = end;
 }

 // Implement the run method to print numbers
 @Override
 public void run() {
     for (int i = start; i <= end; i++) {
         System.out.println(i);
         try {
             // Sleep to simulate some delay and allow thread switching
             Thread.sleep(500); // 500 milliseconds
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}

//Main class to demonstrate multithreading
public class pract7 {
 public static void main(String[] args) {
     // Create two PrintNumbers objects for different ranges
     PrintNumbers printFirstFive = new PrintNumbers(1, 5);
     PrintNumbers printLastFive = new PrintNumbers(6, 10);

     // Create two threads for each task
     Thread thread1 = new Thread(printFirstFive);
     Thread thread2 = new Thread(printLastFive);

     // Start both threads
     thread1.start();
     thread2.start();
 }
}

