package com.wix.yahoo;

import com.wix.steps.yahoo.YahooSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ShareTest {

    @Managed
    private WebDriver driver;

    @Steps
    private YahooSteps yahooSteps;

    @Test
    public void partnersListVerificationTest() {
        yahooSteps.openHomePage();
        yahooSteps.searchForCompany("Wix");
        yahooSteps.fetchHryvniaRate();
        yahooSteps.calculateSharesValueInHryvna(100);
    }
}
