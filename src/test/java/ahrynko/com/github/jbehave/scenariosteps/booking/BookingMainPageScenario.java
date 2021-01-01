package ahrynko.com.github.jbehave.scenariosteps.booking;

import ahrynko.com.github.common.data.EnvironmentProperties;
import ahrynko.com.github.page_object.model.booking.ChooseCityModel;
import ahrynko.com.github.page_object.model.booking.ChooseDateModal;
import ahrynko.com.github.serenity.steps.booking.BookingMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class BookingMainPageScenario {

    @Steps
    private BookingMainPageSteps bookingMainPageSteps;

    @Given("user opened 'Booking main page' by url: '$url'")
    public void openBookingMainPage(final EnvironmentProperties environmentProperties) {
        final String commonUrl = environmentProperties.readProperty();
        bookingMainPageSteps.openMainPageUrl(commonUrl);
    }

    @When("user is trying to change the language to English (US)")
    public void changeLanguageToEnglish() {
        bookingMainPageSteps.selectLanguage();
        bookingMainPageSteps.changeLanguageToEnglish();
    }

    @When("user typed travel place, in search input field: $city")
    public void chooseCity(final ExamplesTable city) {
        final ChooseCityModel chooseCity = city.getRowsAs(ChooseCityModel.class).get(0);
        bookingMainPageSteps.chooseYourCity(chooseCity);
    }

    @When("user choosed travel place in predictive search list")
    public void choosePlace() {
        bookingMainPageSteps.chooseAccuratePlace();
    }

    @When("user choosed travel date trip: $date")
    public void selectTravelDate(final ExamplesTable date) {
        final ChooseDateModal chooseDateModal = date.getRowsAs(ChooseDateModal.class).get(0);
        bookingMainPageSteps.selectTravelDate(chooseDateModal);
    }

    @When("user perform search with travel location")
    public void performSearch() {
        bookingMainPageSteps.performSearch();
    }

}
