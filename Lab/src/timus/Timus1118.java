package timus;

import java.util.Scanner;

public class Timus1118 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int left = scanner.nextInt();
        int right = scanner.nextInt();

        int[] sumDivisors = new int[right + 1];

        for (int divisor = 1; divisor <= right / 2; divisor++) {
            for (int number = divisor * 2; number <= right; number += divisor) {
                sumDivisors[number] += divisor;
            }
        }

        int bestNumber = left;
        int bestSum = sumDivisors[left];

        for (int number = left + 1; number <= right; number++) {
            int currentSum = sumDivisors[number];

            if ((long) currentSum * bestNumber < (long) bestSum * number) {
                bestNumber = number;
                bestSum = currentSum;
            }
        }

        System.out.println(bestNumber);
    }
}