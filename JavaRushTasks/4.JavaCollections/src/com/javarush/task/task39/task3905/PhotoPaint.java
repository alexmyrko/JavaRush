package com.javarush.task.task39.task3905;

public class PhotoPaint {
    private Color oldColor = null;
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (x <0 || x >= image[0].length || y < 0 || y >= image.length || image[y][x].equals(desiredColor))
            return false;
        if (oldColor == null) {
            oldColor = image[y][x];
        }
        if (oldColor == image[y][x]) {
            image[y][x] = desiredColor;
        } else
            return true;
        paintFill(image, y-1, x, desiredColor);
        paintFill(image, y, x-1, desiredColor);
        paintFill(image, y+1, x, desiredColor);
        paintFill(image, y, x+1, desiredColor);
        return true;
    }
}
