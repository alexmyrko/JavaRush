package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static File file;
    public static BufferedReader fileReader;
//    public static BufferedReader fileReader = new BufferedReader(new FileReader(file));

    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            systemOutPrintln(firstFileName);
            systemOutPrintln(secondFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        String line = "";
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
        fileReader.close();
    }

    public interface ReadFileInterface{

        public void setFileName(String fullFileName) throws FileNotFoundException;

        public String getFileContent() throws IOException, InterruptedException;

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String completeLine = "";
        boolean isRead = false;
        public void setFileName(String fullFileName)  {
            file = new File(fullFileName);
            try {
                fileReader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String getFileContent() throws IOException, InterruptedException {
            return completeLine;
        }

        public void run() {
            String line;
            synchronized (fileReader) {
                while (true) {
                    try {
                        line = fileReader.readLine();
                    } catch (IOException e) {
                        System.out.println("Error reading file");
                        isRead = true;
                        break;
                    }
                    if (line != null)
                        completeLine = completeLine + line + " ";
                    else{
                        isRead = true;
                        break;
                    }
                }
            }
        }
    }

}
