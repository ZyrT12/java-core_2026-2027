package Lab5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Assignment8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strings = List.of("кот", "программа", "Java", "университет", "код", "лабораторная");

        System.out.println("Введите минимальную длину строки");
        int length = in.nextInt();

        System.out.println("Исходный список: " + strings);
        List<String> result = filterLongStrings(strings, length);
        System.out.println("Результат: " + result);
    }

    public static List<String> filterLongStrings(List<String> list, int length) {
        return list.stream()
                .filter(str -> str.length() > length)
                .collect(Collectors.toList());
    }
}
