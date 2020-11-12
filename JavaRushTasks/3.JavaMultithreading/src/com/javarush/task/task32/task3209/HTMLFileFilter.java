package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String filename = f.getName().toLowerCase();
        String ext = filename.substring(filename.lastIndexOf(".") + 1);
        if (ext.equals("html") | ext.equals("htm") | f.isDirectory())
            return true;
        else return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
