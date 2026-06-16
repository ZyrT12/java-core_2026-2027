package Lab7;

import java.io.FileWriter;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = "Lab/src/Lab7/files/assignment2.txt";

        System.out.println("Задание 2. Запись текста, введенного с консоли");
        System.out.print("Введите текст для записи в файл: ");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
        }

        System.out.println("Текст записан в файл: " + fileName);
        System.out.println("Записанный текст: " + text);
    }
}
