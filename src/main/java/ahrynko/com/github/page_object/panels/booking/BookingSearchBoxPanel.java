package ahrynko.com.github.page_object.panels.booking;

import ahrynko.com.github.page_object.pages.AbstractPage;
import ahrynko.com.github.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class BookingSearchBoxPanel extends AbstractPanel {

    private static final String SEARCH_INPUT_LOCATOR = ".//input[@id='ss']";

    public BookingSearchBoxPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void typeTravelPlace(final String destination) {
        findBy(SEARCH_INPUT_LOCATOR).waitUntilVisible().type(destination);
    }
}
