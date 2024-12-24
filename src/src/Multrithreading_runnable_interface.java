class PrintNumbers implements Runnable {
    private int start;

    public PrintNumbers(int start) {
        this.start = start;
    }

    @Override
    public void run() {
        for (int i = start; i <= 10; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Multrithreading_runnable_interface {
    public static void main(String[] args) {
        Runnable oddNumbers = new PrintNumbers(1);
        Runnable evenNumbers = new PrintNumbers(2);

        Thread thread1 = new Thread(oddNumbers);
        Thread thread2 = new Thread(evenNumbers);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
