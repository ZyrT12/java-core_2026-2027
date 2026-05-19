package Lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment2Handled {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            System.out.print("Введите номер столбца от 0 до " + (matrix[0].length - 1) + ": ");
            int column = scanner.nextInt();

            System.out.println("Столбец " + column + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][column]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: необходимо ввести целое число.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: столбца с таким номером нет.");
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getClass().getName());
        } finally {
            System.out.println("Работа программы завершена.");
        }
    }
}
