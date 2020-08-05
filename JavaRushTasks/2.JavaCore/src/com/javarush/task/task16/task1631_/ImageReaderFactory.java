package com.javarush.task.task16.task1631_;

import com.javarush.task.task16.task1631_.common.BmpReader;
import com.javarush.task.task16.task1631_.common.ImageReader;
import com.javarush.task.task16.task1631_.common.ImageTypes;
import com.javarush.task.task16.task1631_.common.JpgReader;

/**
 * Created by Alex on 03.02.2020.
 */
public class ImageReaderFactory implements ImageReader{
    public static ImageReader getReader(ImageTypes type) {
        if (type.equals(ImageTypes.BMP))
            return new BmpReader();
        else if (type.equals(ImageTypes.JPG))
            return new JpgReader();
        else if (type.equals(ImageTypes.BMP))
            return new BmpReader();
        else
            return null;
    }
}
