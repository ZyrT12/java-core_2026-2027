package Lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание 6. Поиск слова в файле");
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        System.out.print("Введите слово для поиска: ");
        String word = scanner.nextLine();

        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) {
                    System.out.println(line);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Строки с заданным словом не найдены.");
        }
    }
}
