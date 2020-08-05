package com.javarush.task.task18.task1822_;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
//        FileInputStream inStream = new FileInputStream("D:/file.txt");
        BufferedReader reader = new BufferedReader(new FileReader("D:/file7.txt"));
        int lookId = 134;
        String s;
        int id;
        String productName;
        double price;
        int quantity;
        while ((s = reader.readLine()) != null){
            String[] parts = s.split(" ");
            productName = "";
            if(Integer.parseInt(parts[0]) == lookId) {
                if (parts.length > 4)
                    for (int i = 1; i < parts.length - 2; i++) {
                        productName = productName + parts[i] + " ";
                    }
                price = Double.parseDouble(parts[parts.length - 2]);
                quantity = Integer.parseInt(parts[parts.length - 1]);
                System.out.println(parts[0] + " " + productName + " " + price + " " + quantity);
            }
        }
    }
}