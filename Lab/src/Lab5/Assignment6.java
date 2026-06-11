package Lab5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Assignment6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strings = List.of("Java", "Stream API", "JavaFX", "Spring Boot", "Collections", "Java Core");

        System.out.println("Введите подстроку для поиска");
        String substring = in.nextLine();

        System.out.println("Исходный список: " + strings);
        List<String> result = filterBySubstring(strings, substring);
        System.out.println("Результат: " + result);
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }
}
