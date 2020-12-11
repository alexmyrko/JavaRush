package com.javarush.task.task39.task3913;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry {
    String ip = null;
    String user = null;
    Date date = null;
    Event event;
    Status status;
    Integer task;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public LogEntry(String line) throws ParseException {
        String[] fields = line.split("\\t");
        ip = fields[0];
        user = fields[1];
        date = sdf.parse(fields[2]);
        String eventBlock = fields[3];
        String eventElements[] = eventBlock.split("\\s");
        switch(eventElements[0]){
            case "LOGIN" : event = Event.LOGIN;
                break;
            case "DONE_TASK" : event = Event.DONE_TASK;
                break;
            case "DOWNLOAD_PLUGIN" : event = Event.DOWNLOAD_PLUGIN;
                break;
            case "SOLVE_TASK" : event = Event.SOLVE_TASK;
                break;
            case "WRITE_MESSAGE" : event = Event.WRITE_MESSAGE;
                break;
        }
        if (event == Event.DONE_TASK || event == Event.SOLVE_TASK)
            task = Integer.parseInt(eventElements[1]);
        switch (fields[4]){
            case "ERROR" : status = Status.ERROR;
                break;
            case "OK" : status = Status.OK;
                break;
            case "FAILED" : status = Status.FAILED;
                break;
        }
    }

}
