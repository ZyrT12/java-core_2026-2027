package Lab1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число: ");
        int num = in.nextInt();

        int first = num - 1;
        int second = num;
        int third = num + 1;
        int fourth = (first + second + third) * (first + second + third);

        System.out.println("Последовательность:");
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);

        in.close();
    }
}