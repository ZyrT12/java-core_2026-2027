package timus;

import java.util.Scanner;

import java.util.Scanner;

public class Timus1545 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Напишите количество иероглифов:");
        int n = scanner.nextInt();

        String[] hieroglyphs = new String[n];

        System.out.println("Напишите иероглифы из справочника:");
        for (int i = 0; i < n; i++) {
            hieroglyphs[i] = scanner.next();
        }

        System.out.println("Напишите букву:");
        String letter = scanner.next();

        System.out.println("Подходящие иероглифы:");
        for (int i = 0; i < n; i++) {
            if (hieroglyphs[i].startsWith(letter)) {
                System.out.println(hieroglyphs[i]);
            }
        }
    }
}

