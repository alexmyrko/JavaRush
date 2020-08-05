package com.javarush.task.task13.task1328;

import sun.plugin.dom.views.AbstractView;

public class Robot extends AbstractRobot {
    public String name;
    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
