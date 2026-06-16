package timus;

import java.util.Scanner;

public class Timus2142 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long z = scanner.nextLong();

        long redNeed = Math.max(0, x - a);
        long blueNeed = Math.max(0, y - b);

        if (redNeed + blueNeed > c) {
            System.out.println("There are no miracles in life");
            return;
        }

        long remainingC = c - redNeed - blueNeed;
        long remainingRed = Math.max(0, a - x);
        long remainingBlue = Math.max(0, b - y);

        long totalRemainingMana = remainingRed + remainingBlue + remainingC;

        if (totalRemainingMana >= z) {
            System.out.println("It is a kind of magic");
        } else {
            System.out.println("There are no miracles in life");
        }
    }
}