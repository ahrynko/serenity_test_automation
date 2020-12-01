package ahrynko.com.github.common.data;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {     //считывать Properties из папки properties

    private final Properties properties = new Properties(); //class умеет хранить значение по ключу и значению (считать все properties)
    private static final String PROPERTIES_PATH = "./src/main/resources/properties/%s.properties";

    public PropertiesReader() {
      initProperties();
    }

    private void initProperties() {

        final String propertyType = System.getProperty("environment.name");

        if (!isPropertiesNameCorrect(propertyType)) {
            throw new IllegalStateException("Incorrect property file found!");
        }

        final File propertiesFile = new File(String.format(PROPERTIES_PATH, propertyType.toLowerCase()));
        try {
            properties.load(new FileInputStream(propertiesFile));
        } catch (final IOException e) {
            throw new IllegalStateException("Unable to load properties file!", e);
        }
    }

    public String getProperty(final String propertyName) {    //возврат по ключу значения из property file (load)
        return properties.getProperty(propertyName);
    }

    private Boolean isPropertiesNameCorrect(final String propertyType) {
        return StringUtils.isNotBlank(propertyType);
    }

}
