package ahrynko.com.github.page_object.panels.booking;

import ahrynko.com.github.page_object.pages.AbstractPage;
import ahrynko.com.github.page_object.panels.AbstractPanel;
import lombok.SneakyThrows;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

public class BookingCalendarPanel extends AbstractPanel {

    private static final String NEXT_MONTH_BUTTON = ".//div[@data-bui-ref='calendar-next']";
    private static final String MONTH_NAME_LOCATOR = "(.//div[@class='bui-calendar__month'])[1]";
    private static final String TRAVEL_DAYS_LOCATOR = "(.//div[@class='bui-calendar__wrapper'])[1]//td[@data-date]//span[@aria-hidden]";

    public BookingCalendarPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void selectTravelDate(final String day, final String monthYear) {
        selectTravelMonthAndYear(monthYear);
        selectTravelDay(day);
    }

    @SneakyThrows
    private void selectTravelDay(final String day) {

        List<WebElementFacade> travelDays = findAll(TRAVEL_DAYS_LOCATOR);

            for(WebElementFacade travelDay : travelDays) {
                if(StringUtils.equals(travelDay.getText(), day)) {
                    travelDay.click();
                    break;
                }else if(day.isEmpty() || day.intern().matches("0") || Integer.parseInt(day) > travelDays.size()) {
                  throw new Exception("Unable to select the trip date!");
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
