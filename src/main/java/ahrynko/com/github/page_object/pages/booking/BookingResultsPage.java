package ahrynko.com.github.page_object.pages.booking;

import ahrynko.com.github.page_object.pages.AbstractPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class BookingResultsPage extends AbstractPage {

    private static final String LIST_SEARCH_RESULTS = ".//a[@class='bui-link' and contains(text(), 'Milan')]";

    public BookingResultsPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public String getFirstAvailableHotelDestination() {  //.substring(16,22)
        return StringUtils.substringBetween(findAll(LIST_SEARCH_RESULTS).get(0).getText(),", "," " );
    }
}
