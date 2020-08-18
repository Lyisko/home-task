package com.wix.steps.yahoo;

import com.wix.api.service.RatesService;
import com.wix.pages.yahoo.CompanyPage;
import com.wix.pages.yahoo.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class YahooSteps extends ScenarioSteps {

    private static final Logger logger = LoggerFactory.getLogger(YahooSteps.class);

    private HomePage homePage;
    private CompanyPage companyPage;

    private double hryvniaRate;
    private String companyName;

    @Step
    public void openHomePage() {
        getDriver().manage().window().maximize();
        homePage.open();
    }

    @Step
    public void searchForCompany(String companyName) {
        assertThat(companyName).isNotNull().isNotEmpty();
        this.companyName = companyName;
        homePage.searchField.sendKeys(companyName);
        homePage.dropdownQuotesList.get(0).click();
    }

    @Step
    public void fetchHryvniaRate() {
        hryvniaRate = RatesService.getTodayHryvniaUSDRate();
    }

    @Step
    public void calculateSharesValueInHryvna(int countOfShares) {
        assertThat(countOfShares).isGreaterThan(0);
        assertThat(companyPage.companyFullName.getText().toLowerCase()).contains(companyName.toLowerCase());
        double oneShare = Double.parseDouble(companyPage.openValue.getText().replace(",",""));
        logger.info(String.format("%d shares for %s company will cost you %.2f in Hryvnas",
                countOfShares,
                companyName,
                (countOfShares * hryvniaRate * oneShare)));
    }

}
