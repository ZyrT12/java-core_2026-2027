package timus;

import java.util.Scanner;

public class Timus1021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int[] first = new int[n1];

        for (int i = 0; i < n1; i++) {
            first[i] = scanner.nextInt();
        }

        int n2 = scanner.nextInt();
        int[] second = new int[n2];

        for (int i = 0; i < n2; i++) {
            second[i] = scanner.nextInt();
        }

        int i = 0;
        int j = 0;

        boolean found = false;

        while (i < n1 && j < n2) {
            int sum = first[i] + second[j];

            if (sum == 10000) {
                found = true;
                break;
            }

            if (sum < 10000) {
                i++;
            } else {
                j++;
            }
        }

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}