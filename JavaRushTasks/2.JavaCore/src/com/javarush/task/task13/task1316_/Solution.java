package com.javarush.task.task13.task1316_;
import java.io.*;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        FileOutputStream outStream = new FileOutputStream("D:/data2.txt");

        while(fileInputStream.available() > 0){
            int n = fileInputStream.read();
            System.out.println(n);
            outStream.write(n);
        }

        fileInputStream.close();
        outStream.close();
    }
}
