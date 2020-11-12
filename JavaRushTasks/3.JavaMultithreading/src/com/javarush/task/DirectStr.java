package com.javarush.task;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DirectStr {
    public static Path path = Paths.get("C:\\Karpaty\\Borzhava\\");
    public static Path rootPath = Paths.get("C:\\Karpaty");
    public static Path source = Paths.get("C:\\Karpaty\\Borzhava\\");
    public static Path zipFile = Paths.get("C:\\Karpaty\\");
    public static Path path2 = null;
    static List<Path> fileList = new ArrayList<>();
    static Path relativePath = rootPath.relativize(path);
    static Path filePath = rootPath;
    static Path fileName = Paths.get("Borzhava\\Borzhava_1.JPG");

    public static void main(String[] args) throws IOException {

        System.out.println("path: " + path.toString());
        System.out.println("Root Path: " + rootPath.toString());
        System.out.println("Relative path: " + relativePath.toString());

        collectFileLists(rootPath);

        Path result = Paths.get(filePath.toString(),fileName.toString());
        Path result2 = filePath.resolve(fileName);

        System.out.println(result.getParent());
        System.out.println(result.getFileName());


        System.out.println(result);
        System.out.println(result2);
        for(Path list : fileList){
            System.out.println(list.toString());
        }

        List<Path> pathList = new ArrayList<>();
//        path = Paths.get("C:\\other.zip");
//        pathList.add(Collections.singleton(path));
    }

    public static void collectFileLists(Path path) throws IOException{
        if (Files.isRegularFile(path))
            fileList.add(rootPath.relativize(path));
        else if (Files.isDirectory(path)){
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            for (Path pathElement : directoryStream) {
                if (Files.isDirectory(pathElement))
                    collectFileLists(pathElement);
                else fileList.add(rootPath.relativize(pathElement));
            }
        }
    }
}
