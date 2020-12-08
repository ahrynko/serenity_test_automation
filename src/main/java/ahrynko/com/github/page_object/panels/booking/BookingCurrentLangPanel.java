package ahrynko.com.github.page_object.panels.booking;

import ahrynko.com.github.page_object.pages.AbstractPage;
import ahrynko.com.github.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class BookingCurrentLangPanel extends AbstractPanel {

    private static final String LIST_ALL_LANG = "(.//div[@role='listbox'])[2]//li";

    public BookingCurrentLangPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void changeLanguageToEnglish() {
        List<WebElementFacade> list_lang = findAll(LIST_ALL_LANG);

        for(WebElementFacade lang : list_lang) {
            if (lang.getText().contains("English (US)")) {
                lang.click();
                break;
            }
        }
    }

}
