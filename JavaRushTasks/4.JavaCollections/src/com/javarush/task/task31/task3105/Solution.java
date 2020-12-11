package com.javarush.task.task31.task3105;

import com.sun.org.apache.xerces.internal.impl.xs.opti.SchemaParsingConfig;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path fileToAdd = Paths.get(args[0]);
        Path zipFile = Paths.get(args[1]);
        Map<ZipEntry, ByteArrayOutputStream> map = new HashMap<>();
        ZipEntry zipEntry;
        ByteArrayOutputStream bos;

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(Paths.get(args[1])))){
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                bos = new ByteArrayOutputStream();
                copyData(zipInputStream, bos);
                map.put(zipEntry, bos);
                zipInputStream.closeEntry();
            }
        }

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))){
            boolean hasFound = false;
            String fileToUpdate = fileToAdd.getFileName().toString();
            for(Map.Entry<ZipEntry, ByteArrayOutputStream> entry : map.entrySet()){
                String entryFileName = entry.getKey().getName();
                if (!entry.getKey().isDirectory()) {
                    if (!Paths.get("new/", fileToUpdate).toString().equals(entryFileName)) {
                        zipEntry = new ZipEntry(Paths.get(entry.getKey().getName()).toString());
                        zipOutputStream.putNextEntry(zipEntry);
                        copyData(new ByteArrayInputStream(entry.getValue().toByteArray()), zipOutputStream);
                        zipOutputStream.closeEntry();
                    } else {
                        zipEntry = new ZipEntry(Paths.get(entry.getKey().getName()).toString());
                        zipOutputStream.putNextEntry(zipEntry);
                        Files.copy(fileToAdd, zipOutputStream);
                        zipOutputStream.closeEntry();
                        hasFound = true;
                    }
                }
            }
            if (!hasFound){
                Path newPath = Paths.get("new/", fileToUpdate);
                zipEntry = new ZipEntry(newPath.toString());
                zipOutputStream.putNextEntry(zipEntry);
                Files.copy(fileToAdd, zipOutputStream);
                zipOutputStream.closeEntry();
            }
        }
    }

    public static void copyData(InputStream in, OutputStream out) throws IOException{
        int len;
        byte[] buffer = new byte[1024];
        while((len = in.read(buffer)) > 0){
            out.write(buffer,0, len);
        }
    }
}
