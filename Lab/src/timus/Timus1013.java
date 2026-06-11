package timus;

import java.util.Scanner;

public class Timus1013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long k = scanner.nextLong();
        long m = scanner.nextLong();

        if (n == 1) {
            System.out.println((k - 1) % m);
            return;
        }

        long dpPrevPrev = 1;
        long dpPrev = (k - 1) % m;
        long dpCurrent = 0;

        for (long i = 2; i <= n; i++) {
            dpCurrent = ((k - 1) * (dpPrev + dpPrevPrev)) % m;

            dpPrevPrev = dpPrev;
            dpPrev = dpCurrent;
        }

        System.out.println(dpPrev);
    }
}