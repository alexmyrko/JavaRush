package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket implements Serializable {
    private Path path;
    private static final long serialVersionUID = 1L;

    public FileBucket() throws IOException {
        try{
            path = Files.createTempFile("tmp", null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void putEntry(Entry entry) throws IOException {
        OutputStream outputStream = Files.newOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        out.writeObject(entry);
        out.close();
        outputStream.close();
    }

    public Entry getEntry() {
        Entry entry = null;
        if (getFileSize() > 0)
            try{
                InputStream inputStream = Files.newInputStream(path);
                ObjectInputStream in = new ObjectInputStream(inputStream);
                entry = (Entry) in.readObject();
                in.close();
                inputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return entry;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
