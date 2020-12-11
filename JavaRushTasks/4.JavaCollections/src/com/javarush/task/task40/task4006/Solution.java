package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        String path = url.getPath();
        String host = url.getHost();
        try (Socket socket = new Socket(host, 80);
//            PrintStream out = new PrintStream(socket.getOutputStream());
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            String request = "GET " + path + " HTTP/1.1\n" + "Host: " + host + "\n" + "User-Agent: Mozilla/5.0\n" +
                    "Accept: text/html\n"+ "Connection: close\n";

//            out.println(request);
//            out.println();
            writer.write(request);
            writer.write("\n");
            writer.flush();

            String responseLine;
            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}