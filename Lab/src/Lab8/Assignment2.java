package Lab8;

import Lab8.files.Birthday;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Assignment2{
    public static void main(String[] args) throws Exception {
        System.out.println("Задание 2. Доработка XML-парсера по варианту Birthday");

        File file = new File("Lab/src/Lab8/files/birthdays.xml");
        if (!file.exists()) {
            createInitialXml(file);
        }

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        document.getDocumentElement().normalize();

        Birthday newBirthday = new Birthday("Елена", "Кузнецова", "05.05.2001", 25, "+79000000005");
        document.getDocumentElement().appendChild(createBirthdayElement(document, newBirthday));
        System.out.println("Добавлена запись: " + newBirthday);

        System.out.println("Поиск по фамилии Смирнов:");
        search(document, "Смирнов");

        removeByNameOrSurname(document, "Петрова");
        System.out.println("Удалена запись с именем или фамилией: Петрова");

        saveDocument(document, "Lab/src/Lab8/files/birthdays.xml");
        System.out.println("Изменения сохранены в files/birthdays.xml");
    }

    private static void createInitialXml(File file) throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("birthdays");
        document.appendChild(root);

        for (Birthday birthday : Birthday.getDefaultBirthdays()) {
            root.appendChild(createBirthdayElement(document, birthday));
        }

        saveDocument(document, file.getPath());
    }

    private static Element createBirthdayElement(Document document, Birthday birthday) {
        Element birthdayElement = document.createElement("birthday");
        addTextElement(document, birthdayElement, "name", birthday.getName());
        addTextElement(document, birthdayElement, "surname", birthday.getSurname());
        addTextElement(document, birthdayElement, "birthDate", birthday.getBirthDate());
        addTextElement(document, birthdayElement, "age", String.valueOf(birthday.getAge()));
        addTextElement(document, birthdayElement, "phone", birthday.getPhone());
        return birthdayElement;
    }

    private static void addTextElement(Document document, Element parent, String tagName, String text) {
        Element element = document.createElement(tagName);
        element.setTextContent(text);
        parent.appendChild(element);
    }

    private static void saveDocument(Document document, String fileName) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(new DOMSource(document), new StreamResult(new File(fileName)));
    }

    private static void search(Document document, String query) {
        NodeList list = document.getElementsByTagName("birthday");
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            String name = getText(element, "name");
            String surname = getText(element, "surname");
            String year = getText(element, "birthDate").substring(6);

            if (name.equalsIgnoreCase(query) || surname.equalsIgnoreCase(query) || year.equals(query)) {
                System.out.println(readBirthday(element));
            }
        }
    }

    private static String readBirthday(Element element) {
        return getText(element, "name") + " " + getText(element, "surname")
                + ", дата рождения: " + getText(element, "birthDate")
                + ", возраст: " + getText(element, "age")
                + ", телефон: " + getText(element, "phone");
    }

    private static String getText(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private static void removeByNameOrSurname(Document document, String query) {
        NodeList list = document.getElementsByTagName("birthday");
        for (int i = list.getLength() - 1; i >= 0; i--) {
            Element element = (Element) list.item(i);
            String name = getText(element, "name");
            String surname = getText(element, "surname");

            if (name.equalsIgnoreCase(query) || surname.equalsIgnoreCase(query)) {
                Node parent = element.getParentNode();
                parent.removeChild(element);
            }
        }
    }
}
