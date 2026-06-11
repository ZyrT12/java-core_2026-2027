package Lab5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Assignment11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = List.of(5, 10, 15, 20, 25, 30, 35);

        System.out.println("Введите значение");
        int value = in.nextInt();

        System.out.println("Исходный список: " + numbers);
        List<Integer> result = filterLessNumbers(numbers, value);
        System.out.println("Результат: " + result);
    }

    public static List<Integer> filterLessNumbers(List<Integer> list, int value) {
        return list.stream()
                .filter(number -> number < value)
                .collect(Collectors.toList());
    }
}
