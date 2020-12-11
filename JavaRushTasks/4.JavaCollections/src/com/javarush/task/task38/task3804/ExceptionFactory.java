package com.javarush.task.task38.task3804;

import static com.javarush.task.task38.task3804.ApplicationExceptionMessage.SOCKET_IS_CLOSED;
import static com.javarush.task.task38.task3804.ApplicationExceptionMessage.UNHANDLED_EXCEPTION;
import static com.javarush.task.task38.task3804.DatabaseExceptionMessage.NOT_ENOUGH_CONNECTIONS;
import static com.javarush.task.task38.task3804.DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT;
import static com.javarush.task.task38.task3804.UserExceptionMessage.USER_DOES_NOT_EXIST;
import static com.javarush.task.task38.task3804.UserExceptionMessage.USER_DOES_NOT_HAVE_PERMISSIONS;

public class ExceptionFactory {
    public static Throwable createException(Enum type) {
        if(type ==null)
            return new IllegalArgumentException();
        String message = type.name().charAt(0) + type.name().substring(1).toLowerCase().replace("_", " ");
        if(type ==UNHANDLED_EXCEPTION ||type == SOCKET_IS_CLOSED)
            return new Exception(message);
        if(type == NOT_ENOUGH_CONNECTIONS ||type ==NO_RESULT_DUE_TO_TIMEOUT)
            return new RuntimeException(message);
        if(type ==USER_DOES_NOT_EXIST ||type ==USER_DOES_NOT_HAVE_PERMISSIONS)
            return new Error(message);
        return new IllegalArgumentException();
    }
}
