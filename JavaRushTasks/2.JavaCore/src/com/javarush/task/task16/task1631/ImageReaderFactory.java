package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Alex on 29.01.2019.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) throws IllegalArgumentException{
        if (type == ImageTypes.JPG)
            return new JpgReader();
        else if (type == ImageTypes.BMP)
            return new BmpReader();
        else if (type == ImageTypes.PNG)
            return new PngReader();
        else throw new IllegalArgumentException();
    }
}
