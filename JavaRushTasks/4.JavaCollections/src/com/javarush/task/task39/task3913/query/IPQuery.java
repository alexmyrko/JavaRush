package com.javarush.task.task39.task3913.query;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

public interface IPQuery {
    int getNumberOfUniqueIPs(Date after, Date before) throws IOException, ParseException;

    Set<String> getUniqueIPs(Date after, Date before) throws IOException, ParseException;

    Set<String> getIPsForUser(String user, Date after, Date before) throws ParseException;

    Set<String> getIPsForEvent(Event event, Date after, Date before) throws ParseException;

    Set<String> getIPsForStatus(Status status, Date after, Date before) throws ParseException;
}