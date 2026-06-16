package Lab7;

import java.io.FileWriter;
import java.util.Scanner;

public class Assignment7 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание 7. Запись текста в файл и подсчет символов");
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        System.out.print("Введите текст для записи: ");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
        }

        System.out.println("Текст записан в файл: " + fileName);
        System.out.println("Количество записанных символов: " + text.length());
    }
}
