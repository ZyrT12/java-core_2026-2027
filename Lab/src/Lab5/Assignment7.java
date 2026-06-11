package Lab5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Assignment7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = List.of(6, 9, 12, 15, 18, 21, 25, 30);

        System.out.println("Введите делитель");
        int divisor = in.nextInt();

        System.out.println("Исходный список: " + numbers);
        List<Integer> result = filterDivisibleNumbers(numbers, divisor);
        System.out.println("Результат: " + result);
    }

    public static List<Integer> filterDivisibleNumbers(List<Integer> list, int divisor) {
        return list.stream()
                .filter(number -> number % divisor == 0)
                .collect(Collectors.toList());
    }
}
