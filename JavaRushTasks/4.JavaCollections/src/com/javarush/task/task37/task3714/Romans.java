package com.javarush.task.task37.task3714;

public enum Romans {
    I (1),
    V (5),
    X (10),
    L (50),
    C (100),
    D (500),
    M (1000);

    int number;
    Romans(int number){
        this.number = number;
    }
}
