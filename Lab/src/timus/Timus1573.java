package timus;

import java.util.Scanner;

public class Timus1573 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Напишите количество синих реагентов:");
        int blue = scanner.nextInt();

        System.out.println("Напишите количество красных реагентов:");
        int red = scanner.nextInt();

        System.out.println("Напишите количество жёлтых реагентов:");
        int yellow = scanner.nextInt();

        System.out.println("Напишите количество цветов в рецепте:");
        int k = scanner.nextInt();

        int answer = 1;

        System.out.println("Напишите цвета реагентов из рецепта:");
        for (int i = 0; i < k; i++) {
            String color = scanner.next();

            if (color.equals("Blue")) {
                answer = answer * blue;
            } else if (color.equals("Red")) {
                answer = answer * red;
            } else if (color.equals("Yellow")) {
                answer = answer * yellow;
            }
        }

        System.out.println("Количество способов:");
        System.out.println(answer);
    }
}