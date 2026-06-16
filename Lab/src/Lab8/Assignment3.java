package Lab8;

import Lab8.files.Birthday;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class Assignment3 {
    public static void main(String[] args) throws Exception {
        System.out.println("Задание 3. Доработка JSON-парсера по варианту Birthday");

        File file = new File("Lab/src/Lab8/files/birthdays.json");
        if (!file.exists()) {
            createInitialJson(file);
        }

        JSONArray array = (JSONArray) new JSONParser().parse(new FileReader(file, StandardCharsets.UTF_8));

        Birthday birthday = new Birthday("Елена", "Кузнецова", "05.05.2001", 25, "+79000000005");
        array.add(toJsonObject(birthday));
        System.out.println("Добавлена запись: " + birthday);

        System.out.println("Поиск по имени Иван:");
        search(array, "Иван");

        removeByNameOrSurname(array, "Петрова");
        System.out.println("Удалена запись с именем или фамилией: Петрова");

        try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8)) {
            writer.write(array.toJSONString());
        }
        System.out.println("Изменения сохранены в files/birthdays.json");
    }

    private static void createInitialJson(File file) throws Exception {
        JSONArray array = new JSONArray();
        for (Birthday birthday : Birthday.getDefaultBirthdays()) {
            array.add(toJsonObject(birthday));
        }
        try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8)) {
            writer.write(array.toJSONString());
        }
    }

    private static JSONObject toJsonObject(Birthday birthday) {
        JSONObject object = new JSONObject();
        object.put("name", birthday.getName());
        object.put("surname", birthday.getSurname());
        object.put("birthDate", birthday.getBirthDate());
        object.put("age", birthday.getAge());
        object.put("phone", birthday.getPhone());
        return object;
    }

    private static void search(JSONArray array, String query) {
        for (Object item : array) {
            JSONObject object = (JSONObject) item;
            String name = String.valueOf(object.get("name"));
            String surname = String.valueOf(object.get("surname"));

            if (name.equalsIgnoreCase(query) || surname.equalsIgnoreCase(query)) {
                System.out.println(fromJsonObject(object));
            }
        }
    }

    private static Birthday fromJsonObject(JSONObject object) {
        return new Birthday(
                String.valueOf(object.get("name")),
                String.valueOf(object.get("surname")),
                String.valueOf(object.get("birthDate")),
                Integer.parseInt(String.valueOf(object.get("age"))),
                String.valueOf(object.get("phone"))
        );
    }

    private static void removeByNameOrSurname(JSONArray array, String query) {
        Iterator<?> iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject object = (JSONObject) iterator.next();
            String name = String.valueOf(object.get("name"));
            String surname = String.valueOf(object.get("surname"));

            if (name.equalsIgnoreCase(query) || surname.equalsIgnoreCase(query)) {
                iterator.remove();
            }
        }
    }
}
