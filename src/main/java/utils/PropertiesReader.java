package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static java.util.Objects.isNull;

public class PropertiesReader {
    private static final ThreadLocal<Properties> properties = new ThreadLocal<>();
    private static final String propertyFilePath = "src/test/resources/configuration.properties";

    private static Properties propertiesInit() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties.set(new Properties());
            try {
                properties.get().load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
        return properties.get();
    }

    private static Properties getProperties() {
        if (properties.get() == null) {
            propertiesInit();
        }
        return properties.get();
    }

    public static String getProperty(String propName) {
        if (!isNull(System.getProperty(propName))) {
            return System.getProperty(propName);
        }
        if (!isNull(System.getenv(propName))) {
            return System.getenv(propName);
        }
        return getProperties().getProperty(propName);
    }

}
