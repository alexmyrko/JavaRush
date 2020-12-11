package com.javarush.task.task39.task3913;

import java.util.Date;

public class Entry<K,V> {
    K key;
    V value;
    Event event = null;
    Status status = null;
    Date before;
    Date after;
    boolean betweenDates;

    public Entry(K key, V value, Date after, Date before, boolean betweenDates) {
        this.key = key;
        this.value = value;
        this.after = after;
        this.before = before;
        this.betweenDates = betweenDates;
        switch ((String) value) {
            case "SOLVE_TASK":
                event = Event.SOLVE_TASK;
                break;
            case "DONE_TASK":
                event = Event.DONE_TASK;
                break;
            case "WRITE_MESSAGE":
                event = Event.WRITE_MESSAGE;
                break;
            case "DOWNLOAD_PLUGIN":
                event = Event.DOWNLOAD_PLUGIN;
                break;
            case "LOGIN":
                event = Event.LOGIN;
                break;
            case "OK":
                status = Status.OK;
                break;
            case "FAILED":
                status = Status.FAILED;
                break;
            case "ERROR":
                status = Status.ERROR;
                break;
        }
    }
}
