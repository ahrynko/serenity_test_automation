package ahrynko.com.github.page_object.pages.booking;

import ahrynko.com.github.page_object.pages.AbstractPage;
import ahrynko.com.github.page_object.panels.booking.*;
import org.openqa.selenium.WebDriver;

public class BookingMainPage extends AbstractPage {

    private static final String HEADER_PANEL = ".//div[@id='top']";
    private static final String CURRENT_LANG_MODAL = ".//div[@id='current_language']";
    private static final String SEARCH_BOX_PANEL = ".//div[@class='xpi__content__container']";
    private static final String PREDICTIVE_SEARCH_PANEL = ".//ul[@role='listbox']";
    private static final String CALENDAR_PANEL = ".//div[@class='bui-calendar']";

    public BookingMainPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public BookingHeaderPanel getHeaderPanel() {
        return new BookingHeaderPanel(findBy(HEADER_PANEL).waitUntilVisible(),this );
    }

    public BookingCurrentLangPanel getBookingCurrentLangPanel() {
        return new BookingCurrentLangPanel(findBy(CURRENT_LANG_MODAL).waitUntilVisible(),this );
    }

    public BookingSearchBoxPanel getSearchBoxPanel() {
        return new BookingSearchBoxPanel(findBy(SEARCH_BOX_PANEL).waitUntilVisible(),this );
    }

    public BookingPredictiveSearchPanel getPredictiveSearchPanel() {
        return new BookingPredictiveSearchPanel(findBy(PREDICTIVE_SEARCH_PANEL).waitUntilVisible(),this );
    }

    public BookingCalendarPanel getBookingCalendarPanel() {
        return new BookingCalendarPanel(findBy(CALENDAR_PANEL).waitUntilVisible(),this );
    }

}
