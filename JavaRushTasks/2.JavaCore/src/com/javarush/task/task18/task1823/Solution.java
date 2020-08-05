package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")){
            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            super();
            this.fileName = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run(){
            FileInputStream inStream = null;
            byte[] buffer = null;
            HashMap<Byte,Integer> map = new HashMap<Byte, Integer>();
            try {
                inStream = new FileInputStream(fileName);
                buffer = new byte[inStream.available()];
                inStream.read(buffer);
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < buffer.length; i++){
                if (map.containsKey(buffer[i])){
                    map.put(buffer[i], map.get(buffer[i]) + 1);
                }  else  {
                    map.put(buffer[i], 1);
                }
            }
            int max = 0;
            byte symbol = 0;
            for (Map.Entry entry : map.entrySet()){
                if((int) entry.getValue() > max){
                    max = (int) entry.getValue();
                    symbol = (byte)entry.getKey();
                }
            }
//            System.out.println(symbol + ":" + max);
            resultMap.put(fileName, (int) symbol);
        }
    }
}
