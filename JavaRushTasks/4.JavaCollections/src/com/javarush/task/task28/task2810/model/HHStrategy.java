package com.javarush.task.task28.task2810.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    String url = String.format(URL_FORMAT, "Kiev", 3);

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        Vacancy vacancy;
        List<Vacancy> vacancies = new ArrayList<>();
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
            Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (elements.size() == 0)
                break;
            for(Element element : elements){
                vacancy = new Vacancy();
                vacancy.setTitle(element.getElementsByAttributeValueContaining("data-qa", "vacancy-serp__vacancy-title").text().trim());
                vacancy.setCity(element.getElementsByAttributeValueContaining("data-qa", "vacancy-serp__vacancy-address").text().trim());
                vacancy.setCompanyName(element.getElementsByAttributeValueContaining("data-qa", "vacancy-serp__vacancy-employer").text().trim());
                vacancy.setSalary(element.getElementsByAttributeValueContaining("data-qa", "vacancy-serp__vacancy-compensation").text().trim());
                vacancy.setUrl(element.getElementsByAttributeValueContaining("data-qa", "vacancy-serp__vacancy-title").attr("href").trim());
                vacancy.setSiteName(URL_FORMAT);
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