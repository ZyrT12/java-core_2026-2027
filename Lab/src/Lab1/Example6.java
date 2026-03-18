package Lab1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите фамилию: ");
        String surname = in.nextLine();

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите отчество: ");
        String patronymic = in.nextLine();

        System.out.println("Hello " + surname + " " + name + " " + patronymic);

        in.close();
    }
}