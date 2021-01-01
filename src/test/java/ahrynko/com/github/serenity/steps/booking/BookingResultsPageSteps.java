package ahrynko.com.github.serenity.steps.booking;

import ahrynko.com.github.page_object.pages.booking.BookingResultsPage;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class BookingResultsPageSteps extends ScenarioSteps {

    private final BookingResultsPage bookingResultsPage;

    public BookingResultsPageSteps(final Pages pages) {
        this.bookingResultsPage = pages.getPage(BookingResultsPage.class);
    }

    public String getFirstAvailableHotelDestination() {
        return bookingResultsPage.getFirstAvailableHotelDestination();
    }
}
