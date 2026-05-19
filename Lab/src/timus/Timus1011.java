package Lab2;

import java.util.Scanner;

public class Timus1011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите процент P:");
        double p = in.nextDouble();

        System.out.println("Введите процент Q:");
        double q = in.nextDouble();

        int n = 1;

        while (true) {
            for (int k = 1; k < n; k++) {
                double percent = (double) k * 100 / n;

                if (percent > p && percent < q) {
                    System.out.println("Минимальное число жителей города: " + n);
                    System.out.println("Количество кондукторов: " + k);
                    System.out.println("Процент кондукторов: " + percent);
                    in.close();
                    return;
                }
            }

            n++;
        }
    }
}
