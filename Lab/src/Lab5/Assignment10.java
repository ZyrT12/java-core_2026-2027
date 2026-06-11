package Lab5;

import java.util.List;
import java.util.stream.Collectors;

public class Assignment10 {
    public static void main(String[] args) {
        List<String> strings = List.of("Java", "StreamAPI", "Lab5", "код", "тест!", "Функция", "Data123");

        System.out.println("Исходный список: " + strings);
        List<String> result = filterOnlyLetters(strings);
        System.out.println("Результат: " + result);
    }

    public static List<String> filterOnlyLetters(List<String> list) {
        return list.stream()
                .filter(str -> str.matches("[a-zA-Zа-яА-ЯёЁ]+"))
                .collect(Collectors.toList());
    }
}
