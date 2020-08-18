package com.wix.pages.yahoo;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends PageObject {

    @FindBy(xpath = "//table//td[@data-test='OPEN-value']/span")
    public WebElement openValue;

    @FindBy(xpath = "//h1[@data-reactid='7']")
    public WebElement companyFullName;
}
