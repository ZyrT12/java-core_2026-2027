package Lab4;

import java.util.Scanner;

public class Assignment3Experiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();
            byte[] array = new byte[n];

            for (int i = 0; i < n; i++) {
                System.out.print("array[" + i + "] = ");
                array[i] = scanner.nextByte();
            }

            int sum = 0;
            for (byte value : array) {
                sum += value;
                if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Сумма вышла за диапазон byte");
                }
            }

            byte result = (byte) sum;
            System.out.println("Сумма элементов byte = " + result);
        } catch (Exception e) {
            System.out.println("Сгенерировано исключение: " + e.getClass().getName());
            System.out.println("Сообщение: " + e.getMessage());
        }
    }
}
