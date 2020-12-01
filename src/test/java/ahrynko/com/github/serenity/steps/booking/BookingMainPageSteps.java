package ahrynko.com.github.serenity.steps.booking;

import ahrynko.com.github.page_object.model.booking.ChooseCityModel;
import ahrynko.com.github.page_object.model.booking.ChooseDateModal;
import ahrynko.com.github.page_object.pages.booking.BookingMainPage;
import ahrynko.com.github.page_object.panels.booking.BookingCalendarPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class BookingMainPageSteps extends ScenarioSteps {

    private final BookingMainPage bookingMainPage;

    public BookingMainPageSteps(final Pages pages) {
        this.bookingMainPage = pages.getPage(BookingMainPage.class);
    }

    @Step
    public void openMainPageUrl(final String url) {
        bookingMainPage.openUrl(url);
    }

    @Step
    public void chooseYourCity(final ChooseCityModel chooseCity) {
        bookingMainPage.getSearchBoxPanel().typeTravelPlace(chooseCity.getCity());
    }

    @Step
    public Class<BookingCalendarPanel> chooseAccuratePlace() {
        bookingMainPage.getPredictiveSearchPanel().chooseAccuratePlace();
        return BookingCalendarPanel.class;
    }

    @Step
    public void selectTravelDate(final ChooseDateModal chooseDateModal) {
        bookingMainPage.getBookingCalendarPanel().selectTravelDate(chooseDateModal.getDay(), chooseDateModal.getMonthYear());
    }
}
