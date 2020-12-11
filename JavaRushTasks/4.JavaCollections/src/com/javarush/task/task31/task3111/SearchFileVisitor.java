package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    boolean minSizeCheck;
    boolean maxSizeCheck;
    boolean partOfNameCheck;
    boolean partOfContentCheck;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String stringContent = new String(content);
        boolean isFound = true;
        if (!(partOfNameCheck || partOfContentCheck || minSizeCheck || maxSizeCheck))
            return FileVisitResult.CONTINUE;
        if (partOfNameCheck && !file.getFileName().toString().contains(partOfName))
            isFound = false;
        if(partOfContentCheck && !stringContent.contains(partOfContent))
            isFound = false;
        if (minSizeCheck && content.length < minSize)
            isFound = false;
        if (maxSizeCheck && content.length > maxSize)
            isFound = false;

        if (isFound)
            foundFiles.add(file);
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        partOfNameCheck = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        partOfContentCheck = true;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        minSizeCheck = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        maxSizeCheck = true;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
