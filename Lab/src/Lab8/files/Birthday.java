package Lab8.files;

import java.util.Arrays;
import java.util.List;

public class Birthday {
    private final String name;
    private final String surname;
    private final String birthDate;
    private final int age;
    private final String phone;

    public Birthday(String name, String surname, String birthDate, int age, String phone) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public static List<Birthday> getDefaultBirthdays() {
        return Arrays.asList(
                new Birthday("Анна", "Иванова", "15.03.2001", 25, "+79000000001"),
                new Birthday("Мария", "Петрова", "22.07.2000", 26, "+79000000002"),
                new Birthday("Иван", "Смирнов", "10.11.1999", 27, "+79000000003"),
                new Birthday("Ольга", "Соколова", "01.02.2002", 24, "+79000000004")
        );
    }

    @Override
    public String toString() {
        return name + " " + surname + ", дата рождения: " + birthDate
                + ", возраст: " + age + ", телефон: " + phone;
    }
}
