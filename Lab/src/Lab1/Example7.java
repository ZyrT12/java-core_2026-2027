package Lab1;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите возраст: ");
        int age = in.nextInt();

        System.out.println("Имя пользователя: " + name);
        System.out.println("Возраст пользователя: " + age);

        in.close();
    }
}