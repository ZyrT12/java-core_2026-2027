package Lab6;

import java.util.Arrays;

public class Assignment5 {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {12, 45, 7, 89, 23, 64, 18, 91, 3, 52, 77, 6};
        int processors = Runtime.getRuntime().availableProcessors();
        int threadsCount = Math.min(processors, array.length);
        int[] localMax = new int[threadsCount];
        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            final int index = i;
            int start = i * array.length / threadsCount;
            int end = (i + 1) * array.length / threadsCount;
            threads[i] = new Thread(() -> {
                int max = array[start];
                for (int j = start; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                localMax[index] = max;
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        int result = Arrays.stream(localMax).max().orElse(Integer.MIN_VALUE);
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Количество потоков: " + threadsCount);
        System.out.println("Максимальный элемент: " + result);
    }
}
