package timus;

import java.util.Scanner;

public class Timus2138 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        long v = scanner.nextLong();

        long b1 = v / (256L * 256L * 256L);
        v = v % (256L * 256L * 256L);

        long b2 = v / (256L * 256L);
        v = v % (256L * 256L);

        long b3 = v / 256L;
        long b4 = v % 256L;

        long answer = b4 * 256L * 256L * 256L
                + b3 * 256L * 256L
                + b2 * 256L
                + b1;

        System.out.println(answer);
    }
}