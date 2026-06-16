package timus;

import java.util.Scanner;

public class Timus1079 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxN = 99999;

        int[] a = new int[maxN + 1];
        int[] max = new int[maxN + 1];

        a[0] = 0;
        a[1] = 1;

        max[0] = 0;
        max[1] = 1;

        for (int i = 2; i <= maxN; i++) {
            if (i % 2 == 0) {
                a[i] = a[i / 2];
            } else {
                a[i] = a[i / 2] + a[i / 2 + 1];
            }

            max[i] = Math.max(max[i - 1], a[i]);
        }

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            System.out.println(max[n]);
        }
    }
}