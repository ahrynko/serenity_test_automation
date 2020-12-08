package ahrynko.com.github.page_object.panels.booking;

import ahrynko.com.github.page_object.pages.AbstractPage;
import ahrynko.com.github.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class BookingHeaderPanel extends AbstractPanel {

    private static final String LANG_SELECTOR_LOCATOR = ".//li[@data-id='language_selector']";

    public BookingHeaderPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void selectLanguage() {
        findBy(LANG_SELECTOR_LOCATOR).waitUntilVisible().click();
    }
}

