package Lab7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Assignment8 {
    public static void main(String[] args) throws Exception {
        System.out.println("Задание 8. Сериализация и десериализация объекта");

        String fileName = "Lab/src/Lab7/files/person.dat";
        Person person = new Person("Иван", 30, "Москва");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(person);
        }

        Person restoredPerson;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            restoredPerson = (Person) inputStream.readObject();
        }

        System.out.println("Объект сохранен в файл: " + fileName);
        System.out.println("Восстановленный объект: " + restoredPerson);
        System.out.println("Имя: " + restoredPerson.getName());
        System.out.println("Возраст: " + restoredPerson.getAge());
        System.out.println("Город: " + restoredPerson.getCity());
    }
}
