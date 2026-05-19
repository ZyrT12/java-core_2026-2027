package Lab4;

import java.util.Scanner;

public class Assignment1Experiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("array[" + i + "] = ");
                array[i] = scanner.nextInt();
            }

            int sum = 0;
            int count = 0;
            for (int value : array) {
                if (value > 0) {
                    sum += value;
                    count++;
                }
            }

            if (count == 0) {
                throw new ArithmeticException("Положительные элементы отсутствуют");
            }

            System.out.println("Среднее значение = " + (double) sum / count);
        } catch (Exception e) {
            System.out.println("Сгенерировано исключение: " + e.getClass().getName());
            System.out.println("Сообщение: " + e.getMessage());
        }
    }
}
