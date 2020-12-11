package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MoikrugStrategy implements Strategy{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    String url = String.format(URL_FORMAT, "Dnepropetrovsk", 0);

    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        String siteName = "https://moikrug.ru";
        int page = 0;
        Document doc = null;
        while(true) {
            try {
                doc = getDocument(searchString, page++);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (doc == null)
                break;
            Elements elements = doc.getElementsByAttributeValue("class", "job");
            elements.addAll(doc.getElementsByAttributeValue("class", "job marked"));
            if (elements.size() == 0)
                break;
            for(Element element : elements){
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(element.select("div[class=title]").text().trim());

                vacancy.setSalary(element.select("div[class=salary]").text().trim());
                vacancy.setCity(element.select("span[class=location]").text().trim());
                vacancy.setCompanyName(element.select("[class=company_name]").text());
                

                vacancy.setSiteName(siteName);
                vacancy.setUrl(siteName + element.select("div[class=title]").first().getElementsByTag("a").attr("href").trim());

                vacancies.add(vacancy);
            }
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document document = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36").
                referrer("no-referrer-when-downgrade").get();
        return document;
    }
}
