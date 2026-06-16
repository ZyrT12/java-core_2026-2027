package Lab7;

import java.io.File;
import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание 5. Определение размера файла");
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            System.out.println("Размер файла в байтах: " + file.length());
        } else {
            System.out.println("Файл не найден.");
        }
    }
}
