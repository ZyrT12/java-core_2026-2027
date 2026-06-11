package Lab5;

import java.util.List;
import java.util.stream.Collectors;

public class Example3 {
    public static void main(String[] args) {
        String string = "Название города, Которое начинается не на символ " +
                "К раньше = Название всех слов, Которые начинаются также на строчную, " +
                "букву";

        List<String> strings = List.of(string.split(" "));
        System.out.println("Строка перед преобразованием : " + "\n");
        for (String str : strings) {
            System.out.println(str);
        }

        List<String> stringsAfter = filterCapitalizedStrings(strings);
        System.out.println("\nСтрока после преобразования : " + "\n");
        for (String str : stringsAfter) {
            System.out.println(str);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}
