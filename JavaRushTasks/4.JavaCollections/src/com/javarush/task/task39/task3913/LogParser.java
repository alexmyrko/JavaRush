package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;
import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private List<LogEntry> logEntries = new ArrayList<>();

    public LogParser(Path logDir){
        this.logDir = logDir;
        File[] files = logDir.toFile().listFiles();
        for(File file : files){
            if (file.getName().endsWith(".log")){
                try {
                    logEntries.addAll(parseFile(file));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) throws ParseException {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).
                map(logEntry -> logEntry.ip).collect(Collectors.toSet());
    }

    public Set<String> getUniqueIPs(Date date, Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).filter(logEntry -> logEntry.date.getTime() == date.getTime()).
                map(logEntry -> logEntry.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.user.equals(user)).
                map(logEntry -> logEntry.ip).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == event).
                map(logEntry -> logEntry.ip).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.status == status).
                map(logEntry -> logEntry.ip).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllUsers() throws ParseException {
        return dateValidatedLogs(null, null).map(logEntry -> logEntry.user).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).map(logEntry -> logEntry.user).collect(Collectors.toSet()).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).map(logEntry -> logEntry.event).collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before){
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.ip.equals(ip)).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    public Set<String> getUsersForDate(Date date, Date after, Date before){
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.date.getTime() == date.getTime()).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.LOGIN).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.DOWNLOAD_PLUGIN).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) throws ParseException {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.WRITE_MESSAGE).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.SOLVE_TASK).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.SOLVE_TASK && logEntry.task == task).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.DONE_TASK).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.DONE_TASK && logEntry.task == task).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == event && logEntry.user.equals(user)).
                map(logEntry -> logEntry.date).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.status == Status.FAILED).
                map(logEntry -> logEntry.date).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.status == Status.ERROR).
                map(logEntry -> logEntry.date).
                collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> dates = dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.LOGIN && logEntry.status == Status.OK).
                map(logEntry -> logEntry.date).collect(Collectors.toSet());
        Date minDate = dates.stream().min(Date::compareTo).get();
        return minDate;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date date = dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.user.equals(user) && logEntry.event == Event.SOLVE_TASK && logEntry.task == task).
                map(logEntry -> logEntry.date).
                min(Date::compareTo).get();
        return date;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date date = dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.user.equals(user) && logEntry.event == Event.DONE_TASK && logEntry.task == task).
                map(logEntry -> logEntry.date).
                min(Date::compareTo).get();
        return date;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDatesForUserAndEvent(user, Event.WRITE_MESSAGE, after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDatesForUserAndEvent(user, Event.DOWNLOAD_PLUGIN, after, before);
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return dateValidatedLogs(after, before).map(logEntry -> logEntry.event).collect(Collectors.toSet());
    }

    public Set<Event> getAllEvents(Date date, Date after, Date before) {
        return dateValidatedLogs(after, before).filter(logEntry -> logEntry.date.getTime() == date.getTime()).map(logEntry -> logEntry.event).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return dateValidatedLogs(after, before).filter(logEntry -> logEntry.ip.equals(ip)).
                map(logEntry -> logEntry.event).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return dateValidatedLogs(after, before).filter(logEntry -> logEntry.user.equals(user)).
                map(logEntry -> logEntry.event).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.status == Status.FAILED).
                map(logEntry -> logEntry.event).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.status == Status.ERROR).
                map(logEntry -> logEntry.event).
                collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before){
        Long number =  dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.SOLVE_TASK && logEntry.task == task).
                count();
        return number.intValue();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before){
        Long number = dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.event == Event.DONE_TASK && logEntry.task == task).
                count();
        return number.intValue();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before){
        Map<Integer, Integer> map = new HashMap<>();
        dateValidatedLogs(after, before).filter(logEntry -> logEntry.event == Event.SOLVE_TASK).
                forEach(logEntry -> {
                        map.put(logEntry.task, getNumberOfAttemptToSolveTask(logEntry.task, after, before));
                });
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before){
        Map<Integer, Integer> map = new HashMap<>();
        dateValidatedLogs(after, before).filter(logEntry -> logEntry.event == Event.DONE_TASK).
                forEach(logEntry -> {
                        map.put(logEntry.task, getNumberOfSuccessfulAttemptToSolveTask(logEntry.task, after, before));
                });
        return map;
    }

    public Set<Date> getDates(String mode, String value, Date after, Date before){
        Set<Date> set = dateValidatedLogs(after, before).
                filter(logEntry -> mode.equals("ip") && logEntry.ip.equals(value) ||
                    mode.equals("user") && logEntry.user.equals(value) ||
                        mode.equals("event") && logEntry.event.name().equals(value) ||
                        mode.equals("status") && logEntry.status.name().equals(value)).
                map(logEntry -> logEntry.date).collect(Collectors.toSet());
        return set;
    }

    public Set<Event> getEventsByStatus(String status){
        return dateValidatedLogs(null, null).
                filter(logEntry -> logEntry.status.name().equals(status)).
                map(logEntry -> logEntry.event).
                collect(Collectors.toSet());
    }

    public Set<Event> getEventsByStatus(String status, Date after, Date before){
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.status.name().equals(status)).
                map(logEntry -> logEntry.event).
                collect(Collectors.toSet());
    }


    public Set<Status> getStatuses(String mode, String value, Date after, Date before){
        Set<Status> set = dateValidatedLogs(after, before).
                        filter(logEntry -> mode.equals("ip") && logEntry.ip.equals(value) ||
                                mode.equals("user") && logEntry.user.equals(value) ||
                                mode.equals("date") && (logEntry.date.getTime() == getDate(value).getTime()) ||
                                mode.equals("event") && logEntry.event.name().equals(value)).
                        map(logEntry -> logEntry.status).collect(Collectors.toSet());
        return set;
    }

    public Set<String>getUsersByStatus(String status) {
        return dateValidatedLogs(null, null).
                filter(logEntry -> logEntry.status.name().equals(status)).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }

    public Set<String>getUsersByStatus(String status, Date after, Date before) {
        return dateValidatedLogs(after, before).
                filter(logEntry -> logEntry.status.name().equals(status)).
                map(logEntry -> logEntry.user).
                collect(Collectors.toSet());
    }


    @Override
    public Set<Object> execute(String query) throws ParseException {
        if (query.startsWith("get ip")) {
            if (query.equals("get ip"))
                return new HashSet<>(getUniqueIPs(null, null));
            else {
                Entry queryParameters = getQueryParameters(query.substring("get ip for ".length()));
                switch ((String) queryParameters.key) {
                    case "user":
                        return new HashSet<>(getIPsForUser((String) queryParameters.value, queryParameters.after, queryParameters.before));
                    case "date":
                        Date date = getDate((String) queryParameters.value);
                        return new HashSet<>(getUniqueIPs(date, queryParameters.after, queryParameters.before));
                    case "event":
                        return new HashSet<>(getIPsForEvent(queryParameters.event, queryParameters.after, queryParameters.before));
                    case "status":
                        return new HashSet<>(getIPsForStatus(queryParameters.status, queryParameters.after, queryParameters.before));
                }
            }
        } else if (query.startsWith("get user")) {
            if (query.equals("get user"))
                return new HashSet<>(getAllUsers());
            else {
                Entry queryParameters = getQueryParameters(query.substring("get user for ".length()));
                switch ((String) queryParameters.key) {
                    case "ip":
                        return new HashSet<>(getUsersForIP((String) queryParameters.value, queryParameters.after, queryParameters.before));
                    case "date": {
                        Date date = getDate((String) queryParameters.value);
                        Set<String> users = getUsersForDate(date, queryParameters.after, queryParameters.before);
                        return new HashSet<>(users);
                    }
                    case "event": {
                        switch ((String) queryParameters.value) {
                            case "WRITE_MESSAGE":
                                return new HashSet<>(getWroteMessageUsers(queryParameters.after, queryParameters.before));
                            case "DOWNLOAD_PLUGIN":
                                return new HashSet<>(getDownloadedPluginUsers(queryParameters.after, queryParameters.before));
                            case "LOGIN":
                                return new HashSet<>(getLoggedUsers(queryParameters.after, queryParameters.before));
                            case "SOLVE_TASK":
                                return new HashSet<>(getSolvedTaskUsers(queryParameters.after, queryParameters.before));
                            case "DONE_TASK":
                                return new HashSet<>(getDoneTaskUsers(queryParameters.after, queryParameters.before));
                        }
                        return null;
                    }
                    case "status":
                        if (queryParameters.betweenDates)
                            return new HashSet<>(getUsersByStatus((String) queryParameters.value, queryParameters.after, queryParameters.before));
                        else return new HashSet<>(getUsersByStatus((String) queryParameters.value));
                }
            }
        } else if (query.startsWith("get date")) {
            if (query.equals("get date")) {
                Set<Date> set = new HashSet<>();
                for (LogEntry entry : logEntries) {
                    set.add(entry.date);
                }
                return new HashSet<>(set);
            } else {
                Entry queryParameters = getQueryParameters(query.substring("get date for ".length()));
                return new HashSet<>(getDates((String) queryParameters.key, (String) queryParameters.value, queryParameters.after, queryParameters.before));
            }
        } else if (query.startsWith("get event")) {
            if (query.equals("get event"))
                return new HashSet<>(getAllEvents(null, null));
            else {
                HashSet<Object> events = new HashSet<>();
                Entry queryParameters = getQueryParameters(query.substring("get event for ".length()));
                switch ((String) queryParameters.key) {
                    case "ip":
                        return new HashSet<>(getEventsForIP((String) queryParameters.value, queryParameters.after, queryParameters.before));
                    case "user":
                        return new HashSet<>(getEventsForUser((String) queryParameters.value, queryParameters.after, queryParameters.before));
                    case "date":
                        Date date = getDate((String) queryParameters.value);
                        return new HashSet<>(getAllEvents(date, queryParameters.after, queryParameters.before));
                    case "status":
                        if (queryParameters.betweenDates)
                            return new HashSet<>(getEventsByStatus((String) queryParameters.value, queryParameters.after, queryParameters.before));
                        else
                            return new HashSet<>(getEventsByStatus((String) queryParameters.value));
                }
            }
        } else if (query.startsWith("get status")) {
            if (query.equals("get status")) {
                Set<Status> set = new HashSet<>();
                for (LogEntry entry : logEntries) {
                    set.add(entry.status);
                }
                return new HashSet<>(set);
            } else {
                Entry queryParameters = getQueryParameters(query.substring("get status for ".length()));
                return new HashSet<>(getStatuses((String) queryParameters.key, (String) queryParameters.value, queryParameters.after, queryParameters.before));
            }
        }
        return null;
    }

    private Stream<LogEntry> dateValidatedLogs(Date after, Date before){
        return logEntries.stream().
                filter(logEntry -> {
                    long time  = logEntry.date.getTime();
                    return (after == null || time >= after.getTime()) && (before == null || time <= before.getTime());
                });
    }


    public Entry getQueryParameters(String s) throws ParseException {
        String[] basicParts = s.split(" = ");
        Date after = null;
        Date before = null;
        String[] dates;
        String key = basicParts[0];
        String value = null;
        boolean betweenDates = false;
        if (basicParts[1].split("and date between").length == 1) {
            value = basicParts[1].replace("\"", "").trim();
        } else if (basicParts[1].split(" and date between ").length == 2) {
            String datesArgument = basicParts[1].split(" and date between ")[1];
            value = basicParts[1].split(" and date between ")[0].replace("\"", "");
            System.out.println(value);
            if (datesArgument.split(" and ").length == 2) {
                dates = datesArgument.split("and");
                System.out.println(Arrays.toString(dates));
                after = new Date(getDate(dates[0].replace("\"", "")).getTime()  + 1000);
                before = new Date(getDate(dates[1].replace("\"", "")).getTime() - 1000);
                betweenDates = true;
            }
        }

        Entry entry = new Entry(key, value, after, before, betweenDates);
        System.out.println(entry.key);
        System.out.println(entry.value);
        System.out.println(entry.after);
        System.out.println(entry.before);
        return entry;
    }


    public List<LogEntry> parseFile(File file) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<LogEntry> entries = new ArrayList<>();
        String line;
        while((line = reader.readLine())!= null) {
            entries.add(new LogEntry(line));
        }
        reader.close();
        return entries;
    }

    public Date getDate(String s){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}