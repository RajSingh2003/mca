class LetterThread extends Thread { 
@Override 
public void run() { 
for (char letter = 'A'; letter <= 'J'; letter++) { 
System.out.println(letter); 
try { 
// Sleep for 700 milliseconds between prints 
Thread.sleep(700); 
} catch (InterruptedException e) { 
System.out.println(e); 
} 
} 
} 
} 
class NumberThread extends Thread 
{ 
@Override 
public void run() 
{ 
for (int i = 1; i <= 10; i++) 
{ 
System.out.println(i); 
try 
{ 
Thread.sleep(500); 
} 
catch (InterruptedException e) 
{ 
System.out.println(e); 
} 
} 
} 
} 
public class userTreadClass_twoThread 
{ 
public static void main(String[] args) 
{ 
Thread numberThread = new NumberThread(); 
Thread letterThread = new LetterThread(); 
letterThread.start(); 
numberThread.start(); 
try 
{ 
numberThread.join(); 
letterThread.join(); 
} 
catch (InterruptedException e) 
{ 
System.out.println(e); 
} 
} 
}