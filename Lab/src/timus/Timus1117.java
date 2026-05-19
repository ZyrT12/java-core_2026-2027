package timus;

import java.util.Scanner;

public class Timus1117 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long first = scanner.nextLong();
        long second = scanner.nextLong();

        long left = Math.min(first, second);
        long right = Math.max(first, second);

        long result = prefix(right - 1) - prefix(left - 1);

        System.out.println(result);
    }

    private static long prefix(long n) {
        if (n <= 0) {
            return 0;
        }

        long count = n / 2;
        long result = 2 * sumTrailingZeros(count);

        if (n % 2 == 1) {
            result += trailingZeros(count + 1);
        }

        return result;
    }

    private static long sumTrailingZeros(long n) {
        long result = 0;

        while (n > 0) {
            n /= 2;
            result += n;
        }

        return result;
    }

    private static int trailingZeros(long number) {
        int count = 0;

        while (number % 2 == 0) {
            count++;
            number /= 2;
        }

        return count;
    }
}