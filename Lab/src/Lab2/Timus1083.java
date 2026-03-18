package Lab2;

import java.util.Scanner;

import java.util.Scanner;

public class Timus1083 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число n:");
        int n = in.nextInt();

        System.out.println("Введите восклицательные знаки:");
        String s = in.next();

        int k = s.length();
        int result = 1;

        for (int i = n; i > 0; i = i - k) {
            result = result * i;
        }

        System.out.println("Результат: " + result);

        in.close();
    }
}