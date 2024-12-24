package projct;

//Thread 1: Prints numbers from 1 to 10 with a delay
class PrintNumbersThread extends Thread {
 @Override
 public void run() {
     for (int i = 1; i <= 10; i++) {
         System.out.println(i);
         try {
             // Sleep for 500 milliseconds
             Thread.sleep(500);
         } catch (InterruptedException e) {
             System.out.println(e);
         }
     }
 }
}

//Thread 2: Prints letters from 'A' to 'J' with a delay
class PrintLettersThread extends Thread {
 @Override
 public void run() {
     for (char ch = 'A'; ch <= 'J'; ch++) {
         System.out.println(ch);
         try {
             // Sleep for 700 milliseconds
             Thread.sleep(700);
         } catch (InterruptedException e) {
             System.out.println(e);
         }
     }
 }
}

//Main class to execute the threads
public class pract8 {
 public static void main(String[] args) {
     // Create thread objects for numbers and letters
     PrintNumbersThread numbersThread = new PrintNumbersThread();
     PrintLettersThread lettersThread = new PrintLettersThread();

     // Start both threads
     numbersThread.start();
     lettersThread.start();
 }
}
