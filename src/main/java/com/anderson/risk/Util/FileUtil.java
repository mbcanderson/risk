package com.anderson.risk.Util;

import javax.swing.*;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class FileUtil {

    public static String imagesFileName(String imageName) {
        return "/Users/matthewanderson/work/risk/risk/images/" + imageName + ".png";
    }

    public static Icon iconFromImagesFile(String imageName) {
        String imageFileName = imagesFileName(imageName);
        return new ImageIcon(imageFileName);
    }
}
