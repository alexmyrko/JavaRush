package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    int folders;
    int files;
    long totalSize;
    static Path filePath;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filePath = Paths.get(reader.readLine());
        if (!Files.isDirectory(filePath)) {
            System.out.println(filePath.toString() + " - не папка");
            return;
        }
        Files.walkFileTree(filePath, solution);
        System.out.println("Всего папок - " + solution.folders);
        System.out.println("Всего файлов - " + solution.files);
        System.out.println("Общий размер - " + solution.totalSize);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file))
            files++;
        totalSize += Files.size(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (!dir.equals(filePath))
            folders++;
        return FileVisitResult.CONTINUE;
    }
}
