class Counter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
        System.out.println("Counter: " + counter);
    }
}

public class synchronization_primitives {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            counter.increment();
        });

        Thread thread2 = new Thread(() -> {
            counter.increment();
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
