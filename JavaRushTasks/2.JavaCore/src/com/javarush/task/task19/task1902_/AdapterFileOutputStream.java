package com.javarush.task.task19.task1902_;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    FileOutputStream fileOutputStream;
    AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }
    public void flush() throws IOException {
        fileOutputStream.flush();
    }
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }
    public void close() throws IOException {
        fileOutputStream.close();
    }
}
