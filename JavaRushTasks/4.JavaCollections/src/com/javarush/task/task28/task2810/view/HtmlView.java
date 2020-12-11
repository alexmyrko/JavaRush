package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());
        try {
            updateFile(getUpdatedFileContent(vacancies));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void userCitySelectEmulationMethod() throws IOException {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {
        Document document = null;
        try {
            document = getDocument();
            Element element = document.getElementsByClass("template").first();
            Element newElement = element.clone();
            newElement.removeClass("template").removeAttr("style");
            document.getElementsByAttributeValueEnding("class", "vacancy").remove();
            for (Vacancy vacancy : vacancies) {
                Element currentElement = newElement.clone();
                currentElement.getElementsByClass("city").first().text(vacancy.getCity());
                currentElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                currentElement.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link = currentElement.getElementsByTag("a").first().text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                element.before(currentElement.outerHtml());
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Some exception occurred";
        }
        return document.html();
    }

    private void updateFile(String file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(file);
        writer.close();
    }

    protected Document getDocument() throws IOException{
        Document document = Jsoup.parse(new File(filePath), "UTF-8");
        return document;
    }


}
