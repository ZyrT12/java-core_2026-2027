package Lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment1Handled {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным");
            }

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

            System.out.println("Среднее значение положительных элементов = " + (double) sum / count);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: вместо числа введены некорректные данные.");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getClass().getName());
        } finally {
            System.out.println("Работа программы завершена.");
        }
    }
}
