package com.qaprosoft.carina.demo.gui.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SauceHome extends AbstractPage {
    @FindBy(xpath = "//input[@name = 'user-name']")
    private ExtendedWebElement loginField;

    @FindBy(xpath = "//input[@name = 'password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@name = 'login-button']")
    private ExtendedWebElement loginButton;

    public SauceHome(WebDriver driver) {
        super(driver);
    }

    public void typLogin(String login) {
        loginField.type(login);
    }


    public void typePassword(String password) {
        passwordField.type(password);
    }


    public ItemsPage clickLoginButton() {
        loginButton.click();
        return new ItemsPage(driver);
    }

    public ItemsPage getItemsPage(){
        return new ItemsPage(driver);
    }

}
