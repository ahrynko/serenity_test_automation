package ahrynko.com.github.page_object.panels.booking;

import ahrynko.com.github.page_object.pages.AbstractPage;
import ahrynko.com.github.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class BookingPredictiveSearchPanel extends AbstractPanel {

    private static final String PREDICTIVE_SEARCH_LIST = ".//span[@class='search_hl_name']";
    private static final String CITY_ITEM_LOCATOR = "(//li[@role='option'])[1]";

    public BookingPredictiveSearchPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void chooseAccuratePlace() {
        findBy(CITY_ITEM_LOCATOR).waitUntilVisible().click();
    }
}
