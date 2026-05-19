package Lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество человек N: ");
        int n = scanner.nextInt();

        long startArrayList = System.nanoTime();
        int winnerArrayList = josephus(new ArrayList<>(), n);
        long timeArrayList = System.nanoTime() - startArrayList;

        long startLinkedList = System.nanoTime();
        int winnerLinkedList = josephus(new LinkedList<>(), n);
        long timeLinkedList = System.nanoTime() - startLinkedList;

        System.out.println("Победитель при использовании ArrayList: " + winnerArrayList);
        System.out.println("Время ArrayList: " + timeArrayList + " нс");
        System.out.println("Победитель при использовании LinkedList: " + winnerLinkedList);
        System.out.println("Время LinkedList: " + timeLinkedList + " нс");

        if (timeArrayList < timeLinkedList) {
            System.out.println("Быстрее сработал ArrayList");
        } else if (timeLinkedList < timeArrayList) {
            System.out.println("Быстрее сработал LinkedList");
        } else {
            System.out.println("Время выполнения получилось одинаковым");
        }

        System.out.println("Разница зависит от способа доступа и удаления элементов: "
                + "ArrayList быстро обращается по индексу, но сдвигает элементы при удалении; "
                + "LinkedList быстрее меняет ссылки, но медленнее ищет элемент по индексу.");
    }

    private static int josephus(List<Integer> people, int n) {
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }
}
