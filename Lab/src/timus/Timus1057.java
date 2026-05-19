package Lab3;

import java.util.*;

public class Timus1057 {

    private static long[][] combinations = new long[40][40];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long x = scanner.nextLong();
        long y = scanner.nextLong();
        int k = scanner.nextInt();
        int b = scanner.nextInt();

        buildCombinations();

        long result = count(y, k, b) - count(x - 1, k, b);

        System.out.println(result);
    }

    private static long count(long number, int k, int base) {
        if (number <= 0) {
            return 0;
        }

        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            digits.add((int) (number % base));
            number /= base;
        }

        Collections.reverse(digits);

        long result = 0;
        int usedOnes = 0;

        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(i);
            int remainingPositions = digits.size() - i - 1;

            if (digit == 0) {
                continue;
            }

            if (digit == 1) {
                result += getCombination(remainingPositions, k - usedOnes);
                usedOnes++;
            } else {
                result += getCombination(remainingPositions, k - usedOnes);
                result += getCombination(remainingPositions, k - usedOnes - 1);
                return result;
            }

            if (usedOnes > k) {
                return result;
            }
        }

        if (usedOnes == k) {
            result++;
        }

        return result;
    }

    private static void buildCombinations() {
        for (int i = 0; i < combinations.length; i++) {
            combinations[i][0] = 1;
            combinations[i][i] = 1;

            for (int j = 1; j < i; j++) {
                combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
            }
        }
    }

    private static long getCombination(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }

        return combinations[n][k];
    }
}