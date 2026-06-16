package Lab8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Assignment4 {
    public static void main(String[] args) throws Exception {
        System.out.println("Задание 4. Доработка HTML-парсера");

        Document document = loadPageWithRetry("https://example.com");
        Elements links = document.select("a[href]");

        try (FileWriter writer = new FileWriter("Lab/src/Lab8/files/html_result.txt", StandardCharsets.UTF_8)) {
            writer.write("Заголовок страницы: " + document.title() + System.lineSeparator());
            for (Element link : links) {
                writer.write(link.text() + " -> " + link.attr("abs:href") + System.lineSeparator());
            }
        }

        System.out.println("Данные сохранены в файл: files/html_result.txt");
    }

    private static Document loadPageWithRetry(String url) throws IOException {
        try {
            System.out.println("Подключение к странице: " + url);
            return Jsoup.connect(url).timeout(5000).get();
        } catch (IOException firstError) {
            System.out.println("Ошибка подключения. Выполняется повторная попытка...");

            try {
                return Jsoup.connect(url).timeout(5000).get();
            } catch (IOException secondError) {
                System.out.println("Повторная попытка не выполнена. Используется тестовая HTML-страница.");
                return Jsoup.parse("<html><head><title>Test page</title></head>"
                        + "<body><a href='https://example.com'>Example</a></body></html>");
            }
        }
    }
}
