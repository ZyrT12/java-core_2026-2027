package Lab2;

import java.util.Random;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размер массива");
        int size = in.nextInt();

        int[] nums = new int[size];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
            System.out.println("[" + i + "] = " + nums[i]);
        }

        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        System.out.println("Минимальный элемент = " + min);
        System.out.print("Индексы минимальных элементов: ");

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) {
                System.out.print(i + " ");
            }
        }

        in.close();
    }
}
