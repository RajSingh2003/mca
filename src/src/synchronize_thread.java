class Counter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class synchronize_thread {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new IncrementThread(counter);
        Thread thread2 = new IncrementThread(counter);
        Thread thread3 = new IncrementThread(counter);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Final counter value: " + counter.getCounter());
    }
}
