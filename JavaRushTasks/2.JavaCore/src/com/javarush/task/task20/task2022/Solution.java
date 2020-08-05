package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String name;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.name = fileName;
    }

/*    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }*/

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(name,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);
        Solution solution = new Solution("D:/task2022.txt");
        oos.writeObject(solution);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        Solution solution2 = (Solution) ois.readObject();
        System.out.println(solution2.name);
    }
}
