package timus;

import java.util.Scanner;

public class Timus1796 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] values = {10, 50, 100, 500, 1000, 5000};
        int[] count = new int[6];

        int totalMoney = 0;
        int minBanknote = Integer.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            count[i] = scanner.nextInt();

            if (count[i] > 0) {
                totalMoney += count[i] * values[i];

                if (values[i] < minBanknote) {
                    minBanknote = values[i];
                }
            }
        }

        int ticketPrice = scanner.nextInt();

        int minTickets = totalMoney / ticketPrice;

        int answerCount = 0;
        StringBuilder result = new StringBuilder();

        for (int tickets = 1; tickets <= minTickets; tickets++) {
            int needMoney = tickets * ticketPrice;

            if (needMoney <= totalMoney && needMoney > totalMoney - minBanknote) {
                answerCount++;
                result.append(tickets).append(" ");
            }
        }

        System.out.println(answerCount);
        System.out.println(result.toString().trim());
    }
}