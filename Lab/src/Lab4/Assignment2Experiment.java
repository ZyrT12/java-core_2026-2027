package Lab4;

import java.util.Scanner;

public class Assignment2Experiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            System.out.print("Введите номер столбца: ");
            int column = scanner.nextInt();

            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][column]);
            }
        } catch (Exception e) {
            System.out.println("Сгенерировано исключение: " + e.getClass().getName());
            System.out.println("Сообщение: " + e.getMessage());
        }
    }
}
