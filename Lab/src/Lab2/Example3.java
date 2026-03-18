package Lab2;

import java.util.Scanner;

public class Example3 {

    public static String encrypt(String text, int key) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + key);
        }

        return new String(chars);
    }

    public static String decrypt(String text, int key) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - key);
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите текст для шифрования");
        String text = in.nextLine();

        System.out.println("Введите ключ");
        int key = in.nextInt();
        in.nextLine();

        String result = encrypt(text, key);
        System.out.println("Текст после преобразования: " + result);

        String answer;

        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            answer = in.nextLine();

            if (answer.equals("y")) {
                System.out.println("Результат обратного преобразования: " + decrypt(result, key));
                break;
            } else if (answer.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }

        in.close();
    }
}