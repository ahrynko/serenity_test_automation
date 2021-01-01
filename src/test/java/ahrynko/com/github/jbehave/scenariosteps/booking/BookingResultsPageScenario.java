package ahrynko.com.github.jbehave.scenariosteps.booking;

import ahrynko.com.github.serenity.steps.booking.BookingResultsPageSteps;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Then;

public class BookingResultsPageScenario {

    @Steps
    private BookingResultsPageSteps bookingResultsPageSteps;

    @Then("following travel place text is displayed: '$city'")
    public void getFirstAvailableHotelDestination(final String expectedTravelPlace) {

        final String actualTravelPlace = bookingResultsPageSteps.getFirstAvailableHotelDestination();

        Assertions.assertThat(actualTravelPlace) //  with site
                .as("There is incorrect travel place displayed!")
                .isEqualTo(expectedTravelPlace);  // we expect see
    }
}