package Lab8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;


public class Example6 {
    public static void main(String[] args) {
        try {

            Document doc = Jsoup.connect("http://fat.urfu.ru/index.html")
                    .get();

            Elements newsParent = doc
                    .select("body > table > tbody > tr > td > div > table > " +
                            "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                            "tr > td:nth-child(1)");

            if (!newsParent.isEmpty()) {
                List<Node> nodes = newsParent.get(0).childNodes();

                int count = 0;

                for (int i = 3; i < nodes.size() && count < 10; i++) {
                    if (!(i % 2 == 0) && nodes.get(i) instanceof Element) {
                        Element news = (Element) nodes.get(i);

                        Elements title = news.getElementsByClass("blocktitle");
                        Elements date = news.getElementsByClass("blockdate");

                        if (!title.isEmpty() && !date.isEmpty()) {
                            System.out.println("Тема : " + title.get(0).text());
                            System.out.println("Дата : " + date.get(0).text() + "\n");
                            count++;
                        }
                    }
                }

            } else {
                Elements titles = doc.getElementsByClass("blocktitle");
                Elements dates = doc.getElementsByClass("blockdate");

                int count = Math.min(10, Math.min(titles.size(), dates.size()));

                for (int i = 0; i < count; i++) {
                    System.out.println("Тема : " + titles.get(i).text());
                    System.out.println("Дата : " + dates.get(i).text() + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}