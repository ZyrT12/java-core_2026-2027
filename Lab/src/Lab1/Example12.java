package Lab1;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int currentYear = 2026;

        System.out.print("Введите возраст: ");
        int age = in.nextInt();

        int birthYear = currentYear - age;

        System.out.println("Ваш год рождения: " + birthYear);

        in.close();
    }
}