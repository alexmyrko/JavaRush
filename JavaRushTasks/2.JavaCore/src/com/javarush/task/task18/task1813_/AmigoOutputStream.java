package com.javarush.task.task18.task1813_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
    private FileOutputStream component;
    public AmigoOutputStream(FileOutputStream component) throws FileNotFoundException {
        super(fileName);
        this.component = component;
    }
    public static String fileName = "D:/file5.txt";

    @Override
    public void close() throws IOException {
        System.out.println("yo");
        component.close();
    }

    public static void main(String[] args) throws IOException {
        AmigoOutputStream as = new AmigoOutputStream(new FileOutputStream(fileName));
        as.close();

    }


}