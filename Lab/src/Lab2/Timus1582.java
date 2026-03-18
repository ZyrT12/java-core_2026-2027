package Lab2;

import java.util.Scanner;

public class Timus1582 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите коэффициент k1:");
        double k1 = in.nextDouble();

        System.out.println("Введите коэффициент k2:");
        double k2 = in.nextDouble();

        System.out.println("Введите коэффициент k3:");
        double k3 = in.nextDouble();

        double sum = 1.0 / k1 + 1.0 / k2 + 1.0 / k3;
        double result = 1000.0 / sum;

        System.out.println("Гарантированная сумма до округления: " + result);
        System.out.println("Ответ после округления: " + Math.round(result));

        in.close();
    }
}