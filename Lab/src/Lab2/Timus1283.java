package Lab2;

import java.util.Scanner;

public class Timus1283 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите начальное количество золота:");
        double a = in.nextDouble();

        System.out.println("Введите критическое значение золота:");
        double b = in.nextDouble();

        System.out.println("Введите процент комиссии:");
        double p = in.nextDouble();

        int years = 0;

        while (a > b) {
            a = a * (100 - p) / 100;
            years++;
        }

        System.out.println("Количество лет жизни гномика: " + years);

        in.close();
    }
}
