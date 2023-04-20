package com.qaprosoft.carina.demo.gui.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemsPage extends AbstractPage {

    @FindBy(xpath = "//li[@class ='social_twitter']//a")
    private ExtendedWebElement twitterButton;

    @FindBy(xpath = "//li[@class ='social_facebook']//a")
    private ExtendedWebElement fbButton;

    @FindBy(xpath = "//li[@class ='social_linkedin']//a")
    private ExtendedWebElement instagramButton;


    public ItemsPage(WebDriver driver) {
        super(driver);
    }






}
