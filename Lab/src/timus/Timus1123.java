package timus;

import java.util.Scanner;

public class Timus1123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String salary = scanner.nextLine();
        int n = salary.length();

        char[] result = salary.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            result[n - 1 - i] = result[i];
        }

        if (isGreaterOrEqual(result, salary)) {
            System.out.println(new String(result));
            return;
        }

        int middle = (n - 1) / 2;
        int carry = 1;

        for (int i = middle; i >= 0 && carry > 0; i--) {
            int digit = result[i] - '0' + carry;
            result[i] = (char) ('0' + digit % 10);
            carry = digit / 10;
        }

        if (carry > 0) {
            System.out.print("1");
            for (int i = 0; i < n - 1; i++) {
                System.out.print("0");
            }
            System.out.println("1");
            return;
        }

        for (int i = 0; i < n / 2; i++) {
            result[n - 1 - i] = result[i];
        }

        System.out.println(new String(result));
    }

    private static boolean isGreaterOrEqual(char[] result, String salary) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] > salary.charAt(i)) {
                return true;
            }
            if (result[i] < salary.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}