package Lab3;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();

        if (number == 0) {
            System.out.println("Двоичная запись: 0");
        } else if (number < 0) {
            System.out.print("Двоичная запись: -");
            printBinary(-number);
            System.out.println();
        } else {
            System.out.print("Двоичная запись: ");
            printBinary(number);
            System.out.println();
        }
    }

    private static void printBinary(int number) {
        if (number == 0) {
            return;
        }
        printBinary(number / 2);
        System.out.print(number % 2);
    }
}
