package ahrynko.com.github.page_object.panels.booking;

import ahrynko.com.github.page_object.pages.AbstractPage;
import ahrynko.com.github.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

public class BookingCalendarPanel extends AbstractPanel {

    private static final String NEXT_MONTH_BUTTON = ".//div[@data-bui-ref='calendar-next']";
    private static final String CALENDAR_MONTH = "(.//div[@class='bui-calendar__wrapper'])[1]";
    private static final String MONTH_NAME_LOCATOR = "(.//div[@class='bui-calendar__month'])[1]";
    private static final String TRAVEL_DAY_LOCATOR = ".//td[@data-date]//span[@aria-hidden]";

    public BookingCalendarPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void selectTravelDate(final String day, final String monthYear) {
        selectTravelMonthAndYear(monthYear);
        selectTravelDay(day);
    }

    private void selectTravelDay(final String day) {  //refactor

        List<String> travelDays = Collections.singletonList(findBy(TRAVEL_DAY_LOCATOR).waitUntilVisible().getText());  //refactor

        for(String travelDay : travelDays) {
            if(StringUtils.equals(travelDay, day)) {
                findBy(TRAVEL_DAY_LOCATOR).waitUntilVisible().click();
                break;
            }
        }
    }

    private void selectTravelMonthAndYear(final String monthYear) {

        boolean isMonthNotFound = true;

        while (isMonthNotFound) {

            String month = findBy(MONTH_NAME_LOCATOR).waitUntilVisible().getText();

            if(StringUtils.equals(month, monthYear)) {
                isMonthNotFound = false;
            } else {
                findBy(NEXT_MONTH_BUTTON).waitUntilVisible().click();
            }
        }
    }

}
