package Lab5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Assignment9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = List.of(4, 8, 12, 16, 20, 24, 28);

        System.out.println("Введите значение");
        int value = in.nextInt();

        System.out.println("Исходный список: " + numbers);
        List<Integer> result = filterGreaterNumbers(numbers, value);
        System.out.println("Результат: " + result);
    }

    public static List<Integer> filterGreaterNumbers(List<Integer> list, int value) {
        return list.stream()
                .filter(number -> number > value)
                .collect(Collectors.toList());
    }
}
