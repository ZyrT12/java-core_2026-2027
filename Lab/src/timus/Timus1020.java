package timus;

import java.util.Scanner;

public class Timus1020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double r = scanner.nextDouble();

        double[] x = new double[n];
        double[] y = new double[n];

        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }

        double length = 0;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;

            double dx = x[i] - x[next];
            double dy = y[i] - y[next];

            length += Math.sqrt(dx * dx + dy * dy);
        }

        length += 2 * Math.PI * r;

        System.out.printf("%.2f%n", length);
    }
}