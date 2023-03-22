package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SignUpPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@id = 'uname']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//div[@id = 'body']//input[@type = 'password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//fieldset[@id='udata-f']//input[@type = 'email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//label[@for = 'iagree1']")
    private ExtendedWebElement storeEmailButton;

    @FindBy(xpath = "//label[@for = 'iagree2']")
    private ExtendedWebElement ageButton;

    @FindBy(xpath = "//input[@class = 'button float-right']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class = 'normal-text res-error']//*[last()]")
    private ExtendedWebElement failResult;

    @FindBy(xpath = "//div[@class = 'normal-text res-success']//*[last()]")
    private ExtendedWebElement sucsessResult;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }

    public SignUpPage typeUserNameEdit(String text) {
        userNameField.type(text, 3);
        return this;
    }

    public SignUpPage typePasswordNameEdit(String text) {
        passwordField.type(text, 3);


        // passwordField.sendKeys(, 5);
        return this;
    }

    public SignUpPage typeEmailEdit(String text) {
        emailField.type(text, 3);
        return this;
    }

    public SignUpPage setUserInfo(String email, String login, String pass) {
        typeEmailEdit(email);
        typeUserNameEdit(login);
        typePasswordNameEdit(pass);
        clickAgreeButtons();
        return new SignUpPage(driver);
    }

    public SignUpPage clickAgreeButtons() {
        clickStoreButton();
        clickAgeButton();
        return new SignUpPage(driver);
    }

    public SignUpPage clickStoreButton() {
        storeEmailButton.click(1);
        return new SignUpPage(driver);
    }

    public SignUpPage clickAgeButton() {
        ageButton.click(1);
        return new SignUpPage(driver);
    }

    public void clickSubmitBtn() {
        submitButton.click(1);
    }

    public boolean isElementsPresent() {

        if (userNameField.isElementPresent())
            if (passwordField.isElementPresent())
                if (this.storeEmailButton.isElementPresent())
                    if (this.ageButton.isElementPresent())
                        if (this.emailField.isElementPresent())
                            if (this.submitButton.isElementPresent()) return true;
                            else return false;

        return true;

    }

    public void scrollToPasswordField() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (passwordField.isElementNotPresent(1)) {

            //This will scroll the web page till end.
            js.executeScript("window.scrollBy(0, 1000)");
        }
    }

    public boolean isFailRegistration() {
        if (failResult.isElementPresent()) return true;
        else return false;
    }

    public boolean isSucsessfullRegistration() {
        if (sucsessResult.isElementPresent()) {
            LOGGER.info("registration is sucsessfull: Your account was created..");
            return true;
        } else if (isFailRegistration()) {
            LOGGER.info(" This nickname is already reserved.");
            return false;
        }
        LOGGER.info("before submition");
        return false;
    }

}
