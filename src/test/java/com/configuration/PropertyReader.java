package com.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertyReader {

    private static final Properties properties = new Properties();

    private PropertyReader() {

    }

    public static void loadPropertyFile(String fileName) {

        try (FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                        + "/src/test/resources/config/"
                        + fileName)) {

            properties.clear();
            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load property file : " + fileName, e);
        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new RuntimeException("Property not found : " + key);
        }

        return value;
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(getProperty(key));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }
}