package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    public AmigoOutputStream component;

    public QuestionFileOutputStream(AmigoOutputStream component) {
        this.component = component;
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void close() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        line = reader.readLine();
        if (line.equals("Д"))
            component.close();
    }
}

