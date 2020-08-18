package com.wix.pages.yahoo;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://finance.yahoo.com/")
public class HomePage extends PageObject {

    @FindBy(xpath = "//form[@id='header-search-form']//input")
    public WebElement searchField;

    @FindBy(xpath = "//div[@data-id='search-assist-input-sugglst']//li[@data-type='quotes']")
    public List<WebElement> dropdownQuotesList;
}
