package timus;

import java.util.Scanner;

public class Timus1786 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String name = "Sandro";

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i <= text.length() - name.length(); i++) {
            int cost = 0;

            for (int j = 0; j < name.length(); j++) {
                char current = text.charAt(i + j);
                char needed = name.charAt(j);

                if (current == needed) {
                    cost += 0;
                } else if (Character.toLowerCase(current) == Character.toLowerCase(needed)) {
                    cost += 5;
                } else if (Character.isUpperCase(current) == Character.isUpperCase(needed)) {
                    cost += 5;
                } else {
                    cost += 10;
                }
            }

            if (cost < minCost) {
                minCost = cost;
            }
        }

        System.out.println(minCost);
    }
}