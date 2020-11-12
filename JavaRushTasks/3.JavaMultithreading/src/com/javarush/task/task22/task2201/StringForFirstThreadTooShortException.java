package com.javarush.task.task22.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {
    StringForFirstThreadTooShortException(Throwable e){
        initCause(e);
    }
}
