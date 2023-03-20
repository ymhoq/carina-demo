package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//input[@id = 'uname']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//form[@action='login.php3']//input[@id='upass']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//fieldset[@id='udata-f']//input[@type = 'email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//label[@for = 'iagree1']")
    private ExtendedWebElement storeEmailButton;

    @FindBy(xpath = "//label[@for = 'iagree1']")
    private ExtendedWebElement ageButton;

    @FindBy(xpath = "//input[@class = 'button float-right']")
    private ExtendedWebElement submitButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }

    public SignUpPage typeUserNameEdit(String text) {
        userNameField.type(text, 5);
        return new SignUpPage(driver);
    }

    public SignUpPage typePasswordNameEdit(String text) {
        //passwordField.type(text, 5);
        passwordField.click();
        passwordField.sendKeys(Keys.valueOf("text1234"), 5);
        return new SignUpPage(driver);
    }

    public SignUpPage typeEmailEdit(String text) {
        emailField.type(text, 5);
        return new SignUpPage(driver);
    }

    public SignUpPage setUserInfo(String email, String login, String pass) {
        typeEmailEdit(email);
        typeUserNameEdit(login);
        typePasswordNameEdit(pass);
        return new SignUpPage(driver);
    }

    public SignUpPage clickAgreeBtns() {
        clickAgreeBtn1();
        clickAgreeBtn2();
        return new SignUpPage(driver);
    }

    public SignUpPage clickAgreeBtn1() {
        storeEmailButton.clickByJs();
        return new SignUpPage(driver);
    }

    public SignUpPage clickAgreeBtn2() {
        ageButton.clickByJs();
        return new SignUpPage(driver);
    }

    public void clickSubmitBtn() {
        submitButton.click();
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
}
