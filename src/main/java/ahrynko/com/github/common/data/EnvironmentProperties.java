package ahrynko.com.github.common.data;

public enum EnvironmentProperties {

    BOOKING_BASE_URL("booking.main.page.url");

    private final String propertyKey;

    EnvironmentProperties(final String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String readProperty() {
        final PropertiesReader propertiesReader = new PropertiesReader();
        return propertiesReader.getProperty(propertyKey);
    }
}
