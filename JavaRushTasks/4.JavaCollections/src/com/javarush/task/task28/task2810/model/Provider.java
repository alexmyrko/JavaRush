package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.List;

public class Provider{
    Strategy strategy;
    List<Vacancy> vacancies;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public Provider() {
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString) throws IOException {
        vacancies = strategy.getVacancies(searchString);
        return vacancies;
    }
}
