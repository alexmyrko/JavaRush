package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public FileOutputStream outStream;
    public AmigoOutputStream (FileOutputStream component) throws FileNotFoundException {
        super(fileName);
        this.outStream = component;
    }
    public static String fileName = "C:/tmp/result.txt";


    @Override
    public void close() throws IOException {
        outStream.flush();
        byte [] text = "JavaRush © All rights reserved.".getBytes();
        outStream.write(text);
        outStream.close();
    }

    @Override
    public void flush() throws IOException {
        outStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        outStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        outStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outStream.write(b, off, len);
    }

    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
