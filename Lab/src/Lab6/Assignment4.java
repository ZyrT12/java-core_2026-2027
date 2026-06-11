package Lab6;

public class Assignment4 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            final int threadNumber = i + 1;
            threads[i] = new Thread(() -> System.out.println("Поток №" + threadNumber));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
