package com.motiveintegrator.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class FilesUtils {
    public static String getProperty(String pathFile, String keyProperty) {
        Properties configProp = new Properties();
        try {
            InputStream input = new FileInputStream(pathFile);
            configProp.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configProp.getProperty(keyProperty);
    }

    public static String getConfigProperty(String keyProperty) {
        Properties configProp = new Properties();
        String pathFile="./src/test/resources/config.properties";
        try {
            InputStream input = new FileInputStream(pathFile);
            configProp.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configProp.getProperty(keyProperty);
    }

}


