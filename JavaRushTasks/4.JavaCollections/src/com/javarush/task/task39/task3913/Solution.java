package com.javarush.task.task39.task3913;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
/*        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amigo", null, logParser.getDate("21.10.2021 19:45:25")));
        System.out.println(logParser.getDateWhenUserSolvedTask("Amigo", 18, null, null));
        System.out.println(logParser.getAllEvents(logParser.getDate("12.12.2013 21:56:30"), null));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null, null));
        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(18, null, null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null, null));
        System.out.println(logParser.execute("get ip for user = \"Vasya Pupkin\""));
        System.out.println(logParser.execute("get ip for event = \"LOGIN\""));
        System.out.println(logParser.execute("get ip for status = \"FAILED\""));
        System.out.println(logParser.execute("get ip for date = \"03.01.2014 03:45:23\""));*/
 /*       System.out.println(logParser.execute("get user for status = \"FAILED\""));
        System.out.println(logParser.execute("get user for date = \"14.11.2015 07:08:01\""));
        System.out.println(logParser.execute("get user for event = \"DOWNLOAD_PLUGIN\""));
        System.out.println(logParser.execute("get date for status = \"ERROR\""));*/
        System.out.println(logParser.execute("get status for event = \"WRITE_MESSAGE\" and date between \"30.08.2012 16:08:40\" and \"14.11.2015 07:08:01\""));
        System.out.println(logParser.execute("get ip for user = \"Vasya Pupkin\" and date between 03.01.2014 03:45:23 and 19.03.2016 00:00:00"));
        System.out.println(logParser.execute("get date for status = \"ERROR\" and date between 03.01.2014 03:45:23 and 14.11.2015 07:08:01"));
        System.out.println(logParser.execute("get event for user = \"Vasya Pupkin\" and date between \"03.01.2014 03:45:23\" and \"14.11.2015 07:08:01\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko Moroz\""));
    }
}