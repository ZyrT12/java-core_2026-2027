package Lab7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание 4. Копирование содержимого файла");

        System.out.print("Введите имя исходного файла: ");
        String sourceFileName = scanner.nextLine();

        System.out.print("Введите имя файла для копии: ");
        String targetFileName = scanner.nextLine();

        File sourceFile = new File("Lab/src/Lab7/files/" + sourceFileName);
        File targetFile = new File("Lab/src/Lab7/files/" + targetFileName);

        if (!sourceFile.exists()) {
            System.out.println("Исходный файл не найден: " + sourceFile.getAbsolutePath());
            return;
        }

        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Копирование завершено.");
            System.out.println("Исходный файл: " + sourceFile.getAbsolutePath());
            System.out.println("Файл-копия: " + targetFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}