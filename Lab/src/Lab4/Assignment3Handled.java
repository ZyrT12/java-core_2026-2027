package Lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment3Handled {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным");
            }

            byte[] array = new byte[n];
            for (int i = 0; i < n; i++) {
                System.out.print("array[" + i + "] = ");
                array[i] = scanner.nextByte();
            }

            int sum = 0;
            for (byte value : array) {
                sum += value;
                if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Результат вычисления вышел за диапазон byte от -128 до 127");
                }
            }

            System.out.println("Сумма элементов byte = " + (byte) sum);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не число или число вне диапазона byte.");
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
