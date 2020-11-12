package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ZipAddCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        List<Path> filesToAdd = new ArrayList<>();
        try {
            ConsoleHelper.writeMessage("Добавление файлов в архив.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полный путь файла для добавления в архив: ");
            Path fileSource = Paths.get(ConsoleHelper.readString());
            zipFileManager.addFile(fileSource);
        } catch (PathIsNotFoundException e){
            System.out.println("Файл не найден");
        }

    }
}
