package com.javarush.task.task18.task1823_;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = reader.readLine()).equals("exit")){
            new ReadThread(s);
        }
        System.out.println(resultMap);
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            start();
        }

        @Override
        public void run() {
            FileInputStream inStream = null;
            try {
                inStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Map<Integer, Integer> map = new HashMap<>();
            int data = 0;
            int max = 0;
            int symbol = 0;
            char sl;
            try {
                while (inStream.available()>0){
                    data = inStream.read();
                    if ((data > 32) && (data < 126)) {
                        if (map.get(data) == null)
                            map.put(data, 1);
                        else
                            map.put(data, map.get(data) + 1);
                        if (map.get(data) > max) {
                            max = map.get(data);
                            symbol = data;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            sl = (char)symbol;
            System.out.println(sl + " " + max);
            resultMap.put(String.valueOf(sl), max);
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}