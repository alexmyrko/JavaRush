package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:/"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        Path fileName = Paths.get(url.getFile()).getFileName();
        Path tempFile = Files.createTempFile("temp-",",tmp");
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, tempFile, REPLACE_EXISTING);
        Path destination = downloadDirectory.resolve(fileName);
        Files.move(tempFile, destination, REPLACE_EXISTING);
        return destination;
    }
}
