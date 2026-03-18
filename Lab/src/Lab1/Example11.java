package Lab1;

import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int currentYear = 2026;

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите год рождения: ");
        int birthYear = in.nextInt();

        int age = currentYear - birthYear;

        System.out.println("Имя пользователя: " + name);
        System.out.println("Возраст пользователя: " + age);

        in.close();
    }
}